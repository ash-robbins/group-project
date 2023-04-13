package com.techelevator.dao;

import com.techelevator.model.FamilyAccount;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcFamilyAccountDao implements FamilyAccountDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcFamilyAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public FamilyAccount createFamilyAccount(String familyName, int createdBy) {
        String sql = "INSERT INTO family_account (family_name, created_by) " +
                     "VALUES (?, ?)"+
                     "RETURNING family_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, familyName, createdBy);
        return getFamilyAccountById(newId);
    }

    @Override
    public void addChildAccount(int familyId, int userId, String memberType) {

    }

    @Override
    public void addParentAccount(int familyId, int userId, String memberType) {

    }

    @Override
    public List<FamilyAccount> getAllFamilyAccounts() {
        return null;
    }

    @Override
    public FamilyAccount getFamilyAccountById(int familyId) {
        return null;
    }
}
