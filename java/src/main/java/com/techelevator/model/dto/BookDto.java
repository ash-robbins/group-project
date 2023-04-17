package com.techelevator.model.dto;

import com.techelevator.model.googlebooksapi.ImageLinks;
import com.techelevator.model.googlebooksapi.IndustryIdentifier;

import java.util.List;

public class BookDto {
    private String title;
    private String author;
    private String description;
    private int isbn;
    private String imageLink;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}

