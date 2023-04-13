package com.techelevator.service;

import com.techelevator.model.dto.BookSearchDto;

public class RestGoogleBooksImplementation {

    //call out to endpoint using rest template

    // https://www.googleapis.com/books/v1/volumes?q=intitle:{searchtermvariable}&maxResults=1
//method return searchDTO
    //create a new booksearch dto
    //populate with test values
    //call this method from controller
    //call controller from post man
    //modify, instead of hardcoded values, we'll tie it to google api

    //create parameter that receives search term in method

BookSearchDto bookSearchDto = new BookSearchDto();

    public BookSearchDto getBookSearchDto() {
        String title = "bruh";
        bookSearchDto.setBookTitle(title);
        return bookSearchDto;
    }
}
