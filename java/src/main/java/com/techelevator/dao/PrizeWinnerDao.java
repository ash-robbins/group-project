package com.techelevator.dao;

import com.techelevator.model.PrizeWinner;

public interface PrizeWinnerDao {

    PrizeWinner getPrizeWinner(int prizeWinnerId);

    PrizeWinner getPrizeWinnerByUserId(int userId);

    boolean selectPrizeWinner();
}
