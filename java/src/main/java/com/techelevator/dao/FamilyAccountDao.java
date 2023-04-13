package com.techelevator.dao;

import com.techelevator.model.FamilyAccount;

import java.util.List;

public interface FamilyAccountDao{

      public FamilyAccount createFamilyAccount (String familyName, int createdBy);

      public void addChildAccount(int familyId, int userId, String memberType);

      public void addParentAccount(int familyId, int userId, String memberType);

      public List<FamilyAccount> getAllFamilyAccounts();

      public FamilyAccount getFamilyAccountById(int familyId);
    }

