package com.techelevator.dao;

import com.techelevator.model.FamilyMember;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFamilyMemberDao implements FamilyMemberDao{
    private final JdbcTemplate jdbcTemplate;
    public JdbcFamilyMemberDao (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<FamilyMember> getFamilyMembersByFamilyId(int familyId) {
        List<FamilyMember> familyMembers = new ArrayList<>();
        String sql = "SELECT family_id, user_id, member_type FROM family_members WHERE family_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, familyId);
        while (results.next()) {
            FamilyMember familyMember = mapRowToFamilyMember(results);
            familyMembers.add(familyMember);
        }
        return familyMembers;
    }

    @Override
    public void addFamilyMember(FamilyMember familyMember) {
        String sql = "INSERT INTO family_members (family_id, user_id, member_type) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, familyMember.getFamilyId(), familyMember.getUserId(), familyMember.getMemberType());
    }

    @Override
    public void updateFamilyMember(FamilyMember familyMember) {
        String sql = "UPDATE family_members SET member_type = ? WHERE family_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, familyMember.getMemberType(), familyMember.getFamilyId(), familyMember.getUserId());
    }

    @Override
    public void deleteFamilyMember(int familyId, int userId) {
        String sql = "DELETE FROM family_members WHERE family_id = ? AND user_id = ?";
        jdbcTemplate.update(sql, familyId, userId);
    }

    private FamilyMember mapRowToFamilyMember(SqlRowSet rowSet) {
        FamilyMember familyMember = new FamilyMember();
        familyMember.setFamilyId(rowSet.getInt("family_id"));
        familyMember.setUserId(rowSet.getInt("user_id"));
        familyMember.setMemberType(rowSet.getString("member_type"));
        return familyMember;
    }

}

