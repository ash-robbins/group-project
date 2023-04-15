package com.techelevator.dao;

import com.techelevator.model.PrizeWinner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcPrizeWinnerDao implements PrizeWinnerDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPrizeWinnerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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

    private PrizeWinner mapRowToPrizeWinner(SqlRowSet rowSet) {
        PrizeWinner prizeWinner = new PrizeWinner();
        prizeWinner.setPrizeId(rowSet.getInt("prize_winner_id"));
        prizeWinner.setUserId(rowSet.getInt("user_id"));
        prizeWinner.setPrizeId(rowSet.getInt("prize_id"));
        return prizeWinner;
    }
}
