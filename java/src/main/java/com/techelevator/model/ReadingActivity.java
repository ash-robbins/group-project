package com.techelevator.model;

import java.util.Objects;

public class ReadingActivity {
    private int readingActivityId;
    private int userId;
    private int bookId;
    private String format;
    private int readingTime;
    private String notes;
    private int readingPartnerId;
    private boolean isCompleted;
    private boolean isFavorite;
    private int bookmarkPage;

    public ReadingActivity(int readingActivityId, int userId, int bookId, String format, int readingTime, String notes, int readingPartnerId, boolean isCompleted, boolean isFavorite, int bookmarkPage) {
        this.readingActivityId = readingActivityId;
        this.userId = userId;
        this.bookId = bookId;
        this.format = format;
        this.readingTime = readingTime;
        this.notes = notes;
        this.readingPartnerId = readingPartnerId;
        this.isCompleted = isCompleted;
        this.isFavorite = isFavorite;
        this.bookmarkPage = bookmarkPage;
    }

    public ReadingActivity() {

    }

    public int getReadingActivityId() {
        return readingActivityId;
    }

    public void setReadingActivityId(int readingActivityId) {
        this.readingActivityId = readingActivityId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getReadingTime() {
        return readingTime;
    }

    public void setReadingTime(int readingTime) {
        this.readingTime = readingTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getReadingPartnerId() {
        return readingPartnerId;
    }

    public void setReadingPartnerId(int readingPartnerId) {
        this.readingPartnerId = readingPartnerId;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public int getBookmarkPage() {
        return bookmarkPage;
    }

    public void setBookmarkPage(int bookmarkPage) {
        this.bookmarkPage = bookmarkPage;
    }

    @Override
    public String toString() {
        return "ReadingActivity{" +
                "readingActivityId=" + readingActivityId +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", format='" + format + '\'' +
                ", readingTime=" + readingTime +
                ", notes='" + notes + '\'' +
                ", readingPartnerId=" + readingPartnerId +
                ", isCompleted=" + isCompleted +
                ", isFavorite=" + isFavorite +
                ", bookmarkPage=" + bookmarkPage +
                '}';
    }


}
