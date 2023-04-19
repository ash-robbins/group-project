package com.techelevator.dao;

import com.techelevator.model.FamilyMember;

import java.security.Principal;
import java.util.List;

public interface FamilyMemberDao {
    public List<FamilyMember> getFamilyMembersByCreator(int createdBy);

    public boolean addFamilyMember(int userId, String username);

    public FamilyMember updateFamilyMember(FamilyMember familyMember, int userId);



    public void deleteFamilyMember(int familyId, int userId);


    FamilyMember getFamilyMemberByUserId(int userId);


}