package com.techelevator.dao;

import com.techelevator.model.ReadingActivity;

import java.util.List;

public interface ReadingActivityDao {

    //Trello "Record Reading Activity" Tab
    ReadingActivity createReadingActivity(ReadingActivity readingActivity);

    /* Trello "Check Reading Activity" Tab
    Returns List of All Reading Activities By User */
    List<ReadingActivity> getReadingActivitiesByUserId(int userId);

    /* Trello "Check Reading Activity" Tab
     Returns List of All Reading Activities By User
     SQL statement Aggregate Functions for Summery
     isCompleted is boolean, need a count for if true */
    List<ReadingActivity> getReadingSummaryByUserId(int userId);
}