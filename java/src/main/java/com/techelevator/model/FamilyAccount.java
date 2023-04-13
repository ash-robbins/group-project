package com.techelevator.model;

import java.time.LocalDate;

public class FamilyAccount {
    private int familyId;
    private String familyName;
    private int createdBy;
    private LocalDate createdDate;



    public FamilyAccount(int familyId, String familyName, int createdBy, LocalDate createdDate) {
        this.familyId = familyId;
        this.familyName = familyName;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "FamilyAccount{" +
                "familyId=" + familyId +
                ", familyName='" + familyName + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate=" + createdDate +
                '}';
    }


}
