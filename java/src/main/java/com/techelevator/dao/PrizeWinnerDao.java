package com.techelevator.dao;

import com.techelevator.model.PrizeWinner;
import com.techelevator.model.User;
import com.techelevator.model.WinningUserDto;

public interface PrizeWinnerDao {

    PrizeWinner getPrizeWinner(int prizeWinnerId);

    PrizeWinner getPrizeWinnerByUserId(int userId);

    boolean selectPrizeWinner();

    WinningUserDto selectWinningFamilyMember(int creatorId);

}
