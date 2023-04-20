package com.techelevator.dao;

import com.techelevator.model.FamilyAccount;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFamilyAccountDao implements FamilyAccountDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcFamilyAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public FamilyAccount createFamilyAccount(String familyName, int createdBy, LocalDate createdDate) {
        String sql = "INSERT INTO family_account (family_name, created_by,created_date) " +
                "VALUES (?, ?, ?)" +
                "RETURNING family_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, familyName, createdBy, createdDate);
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
        FamilyAccount familyAccount = null;
        String sql = "SELECT family_id, family_name, created_by, created_date FROM family_account WHERE family_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        if (results.next()) {
            familyAccount = mapRowToFamilyAccount(results);
        }
            return familyAccount;

    }
//******************************************** USING THIS METHOD TO CREATE A FAMILY ACCOUNT *******************************
    @Override
    public FamilyAccount setUpFamilyAccount(FamilyAccount familyAccount) {
        String sql = "INSERT INTO family_account (family_name, created_by, created_date) " +
                "VALUES (?, ?, ?) RETURNING family_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, familyAccount.getFamilyName(), familyAccount.getCreatedBy(), familyAccount.getCreatedDate());
        return getFamilyAccountById(newId);
    }

    @Override
    public boolean hasFamilyAccount(int userId) {

        String sql = "SELECT COUNT(*) FROM family_account WHERE created_by = ?;";
        int numRows = jdbcTemplate.queryForObject(sql, Integer.class, userId);
       return numRows  == 0 ?  false : true;
    }

    @Override
    public FamilyAccount updateFamilyAccount(FamilyAccount familyAccount, int userId) {
        String sql = "UPDATE family_account " +
                "SET family_name = ?, created_by = ?, created_date = ? " +
                "WHERE created_by = ?;";
        jdbcTemplate.update(sql, familyAccount.getFamilyName(), familyAccount.getCreatedBy(), familyAccount.getCreatedDate(), userId);
        return familyAccount;
    }

    @Override
    public void removeFamilyAccount(int familyId) {
    String sql = "DELETE FROM family_account WHERE family_id = ?;";
    jdbcTemplate.update(sql, familyId);
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