package com.techelevator.dao;

import com.techelevator.model.FamilyMember;

import java.util.List;

public interface FamilyMemberDao {
    public List<FamilyMember> getFamilyMembersByFamilyId(int familyId);

    public void addFamilyMember(FamilyMember familyMember);

    public void updateFamilyMember(FamilyMember familyMember);

    public void deleteFamilyMember(int familyId, int userId);

}