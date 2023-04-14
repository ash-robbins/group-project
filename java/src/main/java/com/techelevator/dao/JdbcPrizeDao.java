package com.techelevator.dao;

import com.techelevator.model.Prize;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPrizeDao implements PrizeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPrizeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Prize createPrize(Prize prize) {
        String sql = "INSERT INTO prize (description, milestone, family_id, max_prizes, start_date, end_date) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING prize_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, prize.getDescription(), prize.getMilestone(), prize.getFamilyId(), prize.getMaxPrizes(), prize.getStartDate(), prize.getEndDate());
        return getPrize(newId);
    }

    @Override
    public void editPrize(Prize prize) {
        String sql = "UPDATE prize " +
                "SET description = ?, milestone = ?, family_id = ?, max_prizes = ?, start_date = ?, end_date = ? " +
                "WHERE prize_id = ?;";
        jdbcTemplate.update(sql, prize.getDescription(), prize.getMilestone(), prize.getFamilyId(), prize.getMaxPrizes(), prize.getStartDate(), prize.getEndDate());
    }

    @Override
    public void removePrize(int prizeId) {
        String sql = "DELETE FROM prize WHERE prize_id = ?;";
        jdbcTemplate.update(sql, prizeId);
    }

    @Override
    public List<Prize> listAvailablePrizes() {
        List<Prize> prizes = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT prize_id, description, milestone, family_id, max_prizes, start_date, end_date FROM prize;");
        while (results.next()) {
            prizes.add(mapRowToPrize(results));
        }
        return prizes;
    }

    @Override
    public Prize getPrize(int prizeId) {
        Prize prize = null;
        String sql = "SELECT prize_id, description, milestone, family_id, max_prizes, start_date, end_date " +
                "FROM prize " +
                "WHERE prize_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, prizeId);
        if (results.next()) {
            prize = mapRowToPrize(results);
        }
        return prize;
    }

    private Prize mapRowToPrize(SqlRowSet rowSet) {
        Prize prize = new Prize();
        prize.setPrizeId(rowSet.getInt("prize_id"));
        prize.setDescription(rowSet.getString("description"));
        prize.setMilestone(rowSet.getInt("milestone"));
        prize.setMaxPrizes(rowSet.getInt("max_prizes"));
        prize.setStartDate(rowSet.getDate("start_date").toLocalDate());
        prize.setEndDate(rowSet.getDate("end_date").toLocalDate());
        return prize;
    }
}