package com.techelevator.dao;

import com.techelevator.model.FamilyAccount;

import java.time.LocalDate;
import java.util.List;

public interface FamilyAccountDao{

      public FamilyAccount createFamilyAccount (String familyName, int createdBy, LocalDate createdDate);

      public void addChildAccount(int familyId, int userId, String memberType);

      public void addParentAccount(int familyId, int userId, String memberType);

      public List<FamilyAccount> getAllFamilyAccounts();

      public FamilyAccount getFamilyAccountById(int familyId);

      //ADD FAMILY ACCOUNT
      FamilyAccount setUpFamilyAccount(FamilyAccount familyAccount);

      //UPDATE FAMILY ACCOUNT
      FamilyAccount updateFamilyAccount(FamilyAccount familyAccount, int userId);

      //REMOVE FAMILY ACCOUNT
      void removeFamilyAccount(int familyId);
    }

