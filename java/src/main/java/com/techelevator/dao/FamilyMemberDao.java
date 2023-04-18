package com.techelevator.dao;

import com.techelevator.model.FamilyMember;

import java.util.List;

public interface FamilyMemberDao {
    public List<FamilyMember> getFamilyMembersByFamilyId(int familyId);

    public FamilyMember addFamilyMember(FamilyMember familyMember);

    public FamilyMember updateFamilyMember(FamilyMember familyMember, int userId);



    public void deleteFamilyMember(int familyId, int userId);


    FamilyMember getFamilyMemberByUserId(int userId);


}