package com.techelevator.dao;

import com.techelevator.model.Prize;

import java.util.List;

public interface PrizeDao {

    // Trello "Set Up a Prize" Tab
    Prize createPrize(Prize prize);

    // Trello "Edit a Prize" Tab
    Prize editPrize(Prize prize, int id);

    // Trello "Remove a Prize" Tab
    boolean removePrize(int prizeId);

    // Trello "Trello "See Prizes" Tab
    List<Prize> listAvailablePrizes();

    Prize getPrize(int prizeId);
}
