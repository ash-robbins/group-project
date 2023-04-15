package com.techelevator.dao;

import com.techelevator.model.FamilyAccount;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFamilyAccountDao implements FamilyAccountDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcFamilyAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public FamilyAccount createFamilyAccount(String familyName, int createdBy) {
        String sql = "INSERT INTO family_account (family_name, created_by) " +
                "VALUES (?, ?)" +
                "RETURNING family_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, familyName, createdBy);
        return getFamilyAccountById(newId);
    }

    @Override
    public void addChildAccount(int familyId, int userId, String memberType) {
        String sql = "INSERT INTO family_member (family_id, user_id, member_type) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, familyId, userId, memberType);
    }

    @Override
    public void addParentAccount(int familyId, int userId, String memberType) {
        String sql = "INSERT INTO family_member (family_id, user_id, member_type) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, familyId, userId, memberType);
    }

    @Override

    public List<FamilyAccount> getAllFamilyAccounts() {
        List<FamilyAccount> familyAccounts = new ArrayList<>();
        String sql = "SELECT family_id, family_name, created_by, created_date FROM family_account";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            FamilyAccount familyAccount = mapRowToFamilyAccount(results);
            familyAccounts.add(familyAccount);
        }
        return familyAccounts;
    }

    @Override
    public FamilyAccount getFamilyAccountById(int familyId) {
        String sql = "SELECT family_id, family_name, created_by, created_date FROM family_account WHERE family_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        if (results.next()) {
            return mapRowToFamilyAccount(results);
        } else {
            return null;

        }
    }
    private FamilyAccount mapRowToFamilyAccount(SqlRowSet rowSet) {
        FamilyAccount account = new FamilyAccount();
        account.setFamilyId(rowSet.getInt("family_id"));
        account.setFamilyName(rowSet.getString("family_name"));
        account.setCreatedBy(rowSet.getInt("created_by"));
        account.setCreatedDate(rowSet.getDate("created_date").toLocalDate());
        return account;
    }

}