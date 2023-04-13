package com.techelevator.model;

import java.time.LocalDate;
import java.util.Date;

public class Prize {
    private int prizeId;
    private String description;
    private int milestone;
    private int familyId;
    private int maxPrizes;
    private LocalDate startDate;
    private LocalDate endDate;

    public Prize(int prizeId, String description, int milestone, int familyId, int maxPrizes, LocalDate startDate, LocalDate endDate) {
        this.prizeId = prizeId;
        this.description = description;
        this.milestone = milestone;
        this.familyId = familyId;
        this.maxPrizes = maxPrizes;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Prize() {

    }

    public int getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(int prizeId) {
        this.prizeId = prizeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMilestone() {
        return milestone;
    }

    public void setMilestone(int milestone) {
        this.milestone = milestone;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getMaxPrizes() {
        return maxPrizes;
    }

    public void setMaxPrizes(int maxPrizes) {
        this.maxPrizes = maxPrizes;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "prizeId=" + prizeId +
                ", description='" + description + '\'' +
                ", milestone=" + milestone +
                ", familyId=" + familyId +
                ", maxPrizes=" + maxPrizes +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
