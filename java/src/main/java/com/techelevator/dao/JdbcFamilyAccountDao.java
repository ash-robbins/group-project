package com.techelevator.dao;

import com.techelevator.model.FamilyAccount;

import java.util.List;

public class JdbcFamilyAccountDao implements FamilyAccountDao {
    @Override
    public FamilyAccount createFamilyAccount(String familyName, int createdBy) {
        return null;
    }

    @Override
    public void addChildAccount(int familyId, int userId, String memberType) {

    }

    @Override
    public void addParentAccount(int familyId, int userId, String memberType) {

    }

    @Override
    public List<FamilyAccount> getAllFamilyAccounts() {
        return null;
    }

    @Override
    public FamilyAccount getFamilyAccountById(int familyId) {
        return null;
    }
}
