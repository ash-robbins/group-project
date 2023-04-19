package com.techelevator.controller;

import com.techelevator.dao.FamilyMemberDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.FamilyAccount;
import com.techelevator.model.FamilyMember;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")

public class FamilyMemberController {

    private FamilyMemberDao familyMemberDao;
    private UserDao userDao;

    public FamilyMemberController( FamilyMemberDao familyMemberDao, UserDao userDao) {

        this.familyMemberDao = familyMemberDao;
        this.userDao = userDao;
    }
    /**
     * Add a new family member.
     *
     * @param user the family member to add
     * @return the added family member
     */
    //***************************** THIS METHOD IS TO ADD FAMILY MEMBER TO FAMILY ACCOUNT THROUGH USERNAME ******************
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addFamilyMember", method = RequestMethod.POST)
    public boolean addFamilyMember(Principal principal, @RequestBody User user) {
        int loggedInUserId = userDao.findIdByUsername(principal.getName());
        return familyMemberDao.addFamilyMember(loggedInUserId, user.getUsername());
    }

    @RequestMapping(path = "/familyMembers/{userId}", method = RequestMethod.GET)
    public FamilyMember getFamilyMemberByUserId(@PathVariable int userId) {
        FamilyMember familyMember = familyMemberDao.getFamilyMemberByUserId(userId);
        if (familyMember == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Family Member Not Found.");
        } else {
            return familyMember;
        }
    }


    /**
     * Get all family members by family ID.
     *
     * @return a list of all family members for the specified family
     */

    // ************************** FIND ALL FAMILY MEMBERS THAT BELONG TO A CREATOR OF FAMILY ACCOUNT ************************
    @RequestMapping(path = "/families/familyMembers", method = RequestMethod.GET)
    public List<FamilyMember> getFamilyMembersByCreator(Principal principal) {
        int loggedInUserId = userDao.findIdByUsername(principal.getName());
        return familyMemberDao.getFamilyMembersByCreator(loggedInUserId);
    }




    //update
    @RequestMapping(path = "update/family_member/{id}", method = RequestMethod.PUT)
    public FamilyMember updateFamilyMember(@PathVariable int id, @Valid @RequestBody FamilyMember familyMember) {
        FamilyMember updatedFamilyMember = familyMemberDao.updateFamilyMember(familyMember, id);
        if (updatedFamilyMember == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Family Member Not Found.");
        } else {
            return updatedFamilyMember;
        }
    }

    //delete
    @RequestMapping(path = "/familyMembers/{familyId}/{userId}", method = RequestMethod.DELETE)
    public void deleteFamilyMember(@PathVariable int familyId, @PathVariable int userId) {
        familyMemberDao.deleteFamilyMember(familyId, userId);
    }





}
