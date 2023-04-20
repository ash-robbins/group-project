package com.techelevator.dao;

import com.techelevator.model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class JdbcPrizeWinnerDao implements PrizeWinnerDao {

    private final JdbcTemplate jdbcTemplate;
    private FamilyMemberDao familyMemberDao;
    private UserDao userDao;

    public JdbcPrizeWinnerDao(JdbcTemplate jdbcTemplate, FamilyMemberDao familyMemberDao, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.familyMemberDao = familyMemberDao;
        this.userDao = userDao;
    }

    @Override
    public PrizeWinner getPrizeWinner(int prizeWinnerId) {
        PrizeWinner prizeWinner = null;
        String sql = "SELECT prize_winner_id, user_id, prize_id " +
                "FROM prize_winner " +
                "WHERE prize_winner_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, prizeWinnerId);
        if (results.next()) {
            prizeWinner = mapRowToPrizeWinner(results);
        }
        return prizeWinner;
    }


    @Override
    public PrizeWinner getPrizeWinnerByUserId(int userId) {
        PrizeWinner prizeWinner = null;
        String sql =  "SELECT prize_winner_id, user_id, prize_id " +
                "FROM prize_winner " +
                "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            prizeWinner = mapRowToPrizeWinner(results);
        }
        return prizeWinner;
    }

    @Override
    public boolean selectPrizeWinner() {
        return false;
    }

    @Override
    public WinningUserDto selectWinningFamilyMember(int creatorId) {
        String sql = "select SUM(bookmark_page_number) from reading_activity " +
                "WHERE user_id = ?;";

        List<FamilyMember> familyMembers = new ArrayList<>();
        familyMembers = familyMemberDao.getFamilyMembersByCreator(creatorId);
        List<ReadingActivity> readingActivityList = new ArrayList<>();
        for(FamilyMember member : familyMembers){
            ReadingActivity readingActivity = new ReadingActivity();
            int memberId = member.getUserId();
            if(jdbcTemplate.queryForObject(sql, Integer.class, memberId) != null){
                int totalPages = jdbcTemplate.queryForObject(sql, Integer.class, memberId);
                readingActivity.setBookmarkPage(totalPages);
                readingActivity.setUserId(memberId);
                readingActivityList.add(readingActivity);
            }

        }
       int maxVal = 0;
        int currentVal = 0;
        int winningUserId = 0;
        for( ReadingActivity activity : readingActivityList){
            currentVal = activity.getBookmarkPage();
            if(currentVal > maxVal){
                maxVal = currentVal;
                winningUserId = activity.getUserId();
            }
        }
        String winningUsername = userDao.getUserById(winningUserId).getUsername();

        WinningUserDto winningUserDto = new WinningUserDto();
        winningUserDto.setUsername(winningUsername);
        winningUserDto.setTotalPages(maxVal);
        return winningUserDto;
    }

    private PrizeWinner mapRowToPrizeWinner(SqlRowSet rowSet) {
        PrizeWinner prizeWinner = new PrizeWinner();
        prizeWinner.setPrizeId(rowSet.getInt("prize_winner_id"));
        prizeWinner.setUserId(rowSet.getInt("user_id"));
        prizeWinner.setPrizeId(rowSet.getInt("prize_id"));
        return prizeWinner;
    }
}
