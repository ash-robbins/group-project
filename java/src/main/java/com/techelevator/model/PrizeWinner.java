package com.techelevator.model;

public class PrizeWinner {
    private int prizeWinnerId;
    private int userId;
    private int prizeId;

    public PrizeWinner(int prizeWinnerId, int userId, int prizeId) {
        this.prizeWinnerId = prizeWinnerId;
        this.userId = userId;
        this.prizeId = prizeId;
    }

    public int getPrizeWinnerId() {
        return prizeWinnerId;
    }

    public void setPrizeWinnerId(int prizeWinnerId) {
        this.prizeWinnerId = prizeWinnerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrizeId() {
        return prizeId;
    }

    public void setPrizeId(int prizeId) {
        this.prizeId = prizeId;
    }

    @Override
    public String toString() {
        return "PrizeWinner{" +
                "prizeWinnerId=" + prizeWinnerId +
                ", userId=" + userId +
                ", prizeId=" + prizeId +
                '}';
    }
}
