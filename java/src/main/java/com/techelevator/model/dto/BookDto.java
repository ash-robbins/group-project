package com.techelevator.model.dto;

import com.techelevator.model.googlebooksapi.ImageLinks;
import com.techelevator.model.googlebooksapi.IndustryIdentifier;

import java.util.List;

public class BookDto {
    private String title;
    private List<String> author;
    private String description;
    private List<IndustryIdentifier> industryIdentifier;
    private ImageLinks imageLinks;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IndustryIdentifier> getIndustryIdentifier() {
        return industryIdentifier;
    }

    public void setIndustryIdentifier(List<IndustryIdentifier> industryIdentifier) {
        this.industryIdentifier = industryIdentifier;
    }

    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }
}

