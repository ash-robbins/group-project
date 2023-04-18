package com.techelevator.controller;

import com.techelevator.dao.FamilyMemberDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.FamilyAccount;
import com.techelevator.model.FamilyMember;
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
     * @param familyMember the family member to add
     * @return the added family member
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addFamilyMember", method = RequestMethod.POST)
    public FamilyMember addFamilyMember(@Valid @RequestBody FamilyMember familyMember) {
        return familyMemberDao.addFamilyMember(familyMember);
    }




    /**
     * Get all family members by family ID.
     *
     * @param familyId the ID of the family to retrieve family members from
     * @return a list of all family members for the specified family
     */
    @RequestMapping(path = "/families/{familyId}/familyMembers", method = RequestMethod.GET)
    public List<FamilyMember> getFamilyMembersByFamilyId(@PathVariable int familyId) {
        return familyMemberDao.getFamilyMembersByFamilyId(familyId);
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
