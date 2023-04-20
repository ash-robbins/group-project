package com.techelevator.model;

public class FamilyMember {
    private int familyId;
    private int userId;
    private String memberType;
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public FamilyMember() {

    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "familyId=" + familyId +
                ", userId=" + userId +
                ", memberType='" + memberType + '\'' +
                '}';
    }
}
