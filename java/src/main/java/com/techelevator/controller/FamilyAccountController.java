package com.techelevator.controller;


import com.techelevator.dao.FamilyAccountDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.FamilyAccount;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class FamilyAccountController {

    private FamilyAccountDao familyAccountDao;
    private UserDao userDao;

    public FamilyAccountController(FamilyAccountDao familyAccountDao, UserDao userDao) {
        this.familyAccountDao = familyAccountDao;
        this.userDao = userDao;
    }

    /**
     *
     * creates new family account
     * @param familyAccount
     * @return
     */

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/addFamilyAccount", method = RequestMethod.POST)
    public FamilyAccount setUpFamilyAccount(@Valid @RequestBody FamilyAccount familyAccount) {
        return familyAccountDao.setUpFamilyAccount(familyAccount);
    }

    @RequestMapping(path = "family_account/{id}")
    public FamilyAccount getFamilyAccountByFamilyId(@PathVariable int id) {
        FamilyAccount familyAccount = new FamilyAccount();
        familyAccount = familyAccountDao.getFamilyAccountById(id);
        if (familyAccount == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Family Account.");
        } else {
            return familyAccount;
        }
    }


    /**
     *
     * allows logged-in user to update family
     * @param familyAccount
     * @param principal
     * @return
     */
    @RequestMapping(path = "update/family_account/{id}")
    public FamilyAccount updateFamilyAccount(@Valid @RequestBody FamilyAccount familyAccount, Principal principal) {
        int loggedInUserId = userDao.findIdByUsername(principal.getName());
        FamilyAccount updatedFamily = familyAccountDao.updateFamilyAccount(familyAccount, loggedInUserId);
        if (updatedFamily == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Family Account Not Found.");
        } else {
            return updatedFamily;
        }
    }

    /**
     *
     * deletes family account by family id
     * @param id
     */
    public void deleteFamilyAccount(@PathVariable int id){
        familyAccountDao.removeFamilyAccount(id);
    }
}
