package com.techelevator.model.dto;

import com.techelevator.model.googlebooksapi.VolumeInfo;

import java.math.BigDecimal;

//A DTO (Data Transfer Object): This is a Java class
// that represents the data that you want to retrieve
// from the Google Books API.
//we want to retrieve title,previewLink,

public class BookSearchDto {

    private String bookTitle;
    private String bookSubtitle;
    private String author;
    private String description;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookSubtitle() {
        return bookSubtitle;
    }

    public void setBookSubtitle(String bookSubtitle) {
        this.bookSubtitle = bookSubtitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
