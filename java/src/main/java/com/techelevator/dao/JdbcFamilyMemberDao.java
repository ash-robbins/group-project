package com.techelevator.dao;

import com.techelevator.model.FamilyMember;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFamilyMemberDao implements FamilyMemberDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcFamilyMemberDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // ************************** FIND ALL FAMILY MEMBERS THAT BELONG TO A CREATOR OF FAMILY ACCOUNT ************************

    @Override
    public List<FamilyMember> getFamilyMembersByCreator(int createdBy) {
        List<FamilyMember> familyMembers = new ArrayList<>();
        String sql1 = "SELECT family_id FROM family_account WHERE created_by = ?";
        int familyId = jdbcTemplate.queryForObject(sql1, Integer.class, createdBy);
        String sql = "SELECT family_id, user_id, member_type FROM family_member WHERE family_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        while (results.next()) {
            FamilyMember familyMember = mapRowToFamilyMember(results);
            familyMembers.add(familyMember);
        }
        return familyMembers;
    }

    @Override
    public boolean addFamilyMember(int userId, String username) {
        String sql1 = "SELECT family_id FROM family_account WHERE created_by = ?";
        int familyId = jdbcTemplate.queryForObject(sql1, Integer.class, userId);
        String sql2 = "SELECT user_id FROM users WHERE username = ?";
        int userIdToAdd = jdbcTemplate.queryForObject(sql2, Integer.class, username);
        String sql = "INSERT INTO family_member (family_id, user_id, member_type) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, familyId, userIdToAdd, "child") == 1;

    }



    @Override
    public FamilyMember updateFamilyMember(FamilyMember familyMember, int userId) {
        String sql = "UPDATE family_member " +
                "SET member_type = ? " +
                "WHERE family_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, familyMember.getMemberType(), familyMember.getFamilyId(), userId);
        return familyMember;
    }




    @Override
    public void deleteFamilyMember(int familyId, int userId) {
        String sql = "DELETE FROM family_member WHERE family_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, familyId, userId);
    }

    @Override
    public FamilyMember getFamilyMemberByUserId(int userId) {
        FamilyMember familyMember = null;
        String sql = "SELECT family_id, user_id, member_type FROM family_member WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            familyMember = mapRowToFamilyMember(results);
        }
        return familyMember;
    }





    private FamilyMember mapRowToFamilyMember(SqlRowSet rowSet) {
        FamilyMember familyMember = new FamilyMember();
        familyMember.setFamilyId(rowSet.getInt("family_id"));
        familyMember.setUserId(rowSet.getInt("user_id"));
        familyMember.setMemberType(rowSet.getString("member_type"));
        return familyMember;
    }

}

