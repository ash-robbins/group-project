package com.techelevator.dao;

import com.techelevator.model.ReadingActivity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcReadingActivityDao implements ReadingActivityDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReadingActivityDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public ReadingActivity createReadingActivity(ReadingActivity readingActivity) {
        String sql = "INSERT INTO reading_activity (user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number) " +
                "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING reading_activity_id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                readingActivity.getUserId(), readingActivity.getBookId(), readingActivity.getFormat(), readingActivity.getReadingTime(),readingActivity.getNotes(), readingActivity.getReadingPartnerId(),
                readingActivity.isCompleted(), readingActivity.isFavorite(), readingActivity.getBookmarkPage());
        return getReadingActivity(newId, readingActivity.getUserId());
    }

    @Override
    public List<ReadingActivity> getReadingActivitiesByUserId(int userId) {
        List<ReadingActivity> activities = new ArrayList<>();
        String sql = "SELECT reading_activity_id, user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number " +
                "FROM reading_activity " +
                "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            activities.add(mapRowToReadingActivity(results));
        }
        return activities;
    }

    @Override
    public ReadingActivity getReadingSummaryByUserId(int userId) {
        ReadingActivity readingSummary = null;
        String sql = "SELECT SUM(reading_time) as total_reading_time, COUNT(is_completed = true) as completed_books, COUNT(is_completed = false) as readings_in_progress " +
                "FROM reading_activity " +
                "WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            readingSummary = mapRowToReadingActivity(results);
        }
        return readingSummary;
    }
// TODO GET READING ACTIVITY METHOD
    @Override
    public ReadingActivity getReadingActivity(int bookId, int userId) {
        ReadingActivity readingActivity = null;
        String sql = "SELECT reading_activity_id, user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number " +
                "FROM reading_activity " + "WHERE book_id = ?;";
//        String sql = "SELECT reading_activity_id, user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number " +
//                "FROM reading_activity " + "WHERE reading_activity_id = ? AND user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookId);
        if (results.next()) {
            readingActivity = mapRowToReadingActivity(results);
        }
        return readingActivity;
    }

    @Override
    public ReadingActivity getReadingActivityByBookId(int bookId) {
        ReadingActivity readingActivity = null;
        String sql = "SELECT reading_activity_id, user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number " +
                "FROM reading_activity " + "WHERE book_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookId);
        if (results.next()) {
            readingActivity = mapRowToReadingActivity(results);
        }
        return readingActivity;
    }

    @Override
    public ReadingActivity updateReadingActivity(ReadingActivity readingActivity, int userId) {
        String sql = "UPDATE reading_activity " +
        "SET user_id = ?, book_id = ?, format = ?, reading_time = ?, notes = ?, reading_partner_id = ?, is_completed = ?, is_favorite = ?, bookmark_page_number = ? " +
                "WHERE book_id = ? AND user_id = ?;";
        String sql1 = "SELECT reading_time, bookmark_page_number FROM reading_activity WHERE book_id = ? AND user_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql1, readingActivity.getBookId(), userId);
        int initialReadingTime = result.getInt("reading_time");
        int originalPage = result.getInt("bookmark_page_number");
        int finalReadingTime = initialReadingTime + readingActivity.getReadingTime();
        int finalPageNum = originalPage + readingActivity.getBookmarkPage();
        int checkSuccess = jdbcTemplate.update(sql, userId, readingActivity.getBookId(), readingActivity.getFormat(), finalReadingTime, readingActivity.getNotes(), readingActivity.getReadingPartnerId(), readingActivity.isCompleted(), readingActivity.isFavorite(), finalPageNum, readingActivity.getBookId(), userId);
        return readingActivity;
    }


    private ReadingActivity mapRowToReadingActivity(SqlRowSet rowSet) {
        ReadingActivity readingActivity = new ReadingActivity();
        readingActivity.setReadingActivityId(rowSet.getInt("reading_activity_id"));
        readingActivity.setUserId(rowSet.getInt("user_id"));
        readingActivity.setBookId(rowSet.getInt("book_id"));
        readingActivity.setFormat(rowSet.getString("format"));
        readingActivity.setReadingTime(rowSet.getInt("reading_time"));
        readingActivity.setNotes(rowSet.getString("notes"));
        readingActivity.setReadingPartnerId(rowSet.getInt("reading_partner_id"));
        readingActivity.setCompleted(rowSet.getBoolean("is_completed"));
        readingActivity.setFavorite(rowSet.getBoolean("is_favorite"));
        readingActivity.setBookmarkPage(rowSet.getInt("bookmark_page_number"));
        return readingActivity;
    }
}
