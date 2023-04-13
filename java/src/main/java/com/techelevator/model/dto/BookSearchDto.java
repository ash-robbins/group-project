package com.techelevator.model.dto;

import com.techelevator.model.googlebooksapi.VolumeInfo;

import java.math.BigDecimal;

//A DTO (Data Transfer Object): This is a Java class
// that represents the data that you want to retrieve
// from the Google Books API.
//we want to retrieve title,previewLink,

public class BookSearchDto {

       private String bookTitle;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
