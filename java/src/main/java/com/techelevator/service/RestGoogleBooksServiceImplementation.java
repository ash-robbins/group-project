package com.techelevator.service;

import com.google.gson.Gson;

import com.techelevator.model.dto.BookDto;
import com.techelevator.model.dto.BookGoogleDto;
import com.techelevator.model.dto.BookSearchDto;
import com.techelevator.model.googlebooksapi.GoogleBooks;
import com.techelevator.model.googlebooksapi.Items;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.print.Book;
import java.util.Map;

@Service
public class RestGoogleBooksServiceImplementation implements RestGoogleBooksService {
    private static final String API_KEY = "API_KEY";
    private static final String API_VALUE="AIzaSyCP7XUcC-GUKqAhetF1-kZrtzoh5HEO3QU";
    private static final String API_URL= "https://www.googleapis.com/books/v1/volumes?q=intitle:";

    private final RestTemplate restTemplate = new RestTemplate();

    public RestGoogleBooksServiceImplementation(){
    }
    //call out to endpoint using rest template

    // https://www.googleapis.com/books/v1/volumes?q=intitle:{searchtermvariable}&maxResults=1
//method return searchDTO
    //create a new booksearch dto
    //populate with test values
    //call this method from controller
    //call controller from post man
    //modify, instead of hardcoded values, we'll tie it to google api

    //create parameter that receives search term in method

@Override
    public BookSearchDto getBookSearchDto(String searchTerm) {
//        String searchTerm = "empire";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(API_KEY, API_VALUE);

        BookSearchDto bookSearchDto = new BookSearchDto();
        String title = "bruh";
        String subtitle = "more bruh";
        String author = "dab";
        String description =  "once upon a time...bruh happened";

        HttpEntity request = new HttpEntity(headers);

//        ResponseEntity<String> response = restTemplate.exchange(
//                API_URL + searchTerm +"&maxResults=1",
//                HttpMethod.GET,
//                request,
//                String.class
//            );
//        String jsonString = response.getBody();
//        Gson gson = new Gson();
//        BookGoogleDto book = gson.fromJson(jsonString, BookGoogleDto.class);

        bookSearchDto.setBookTitle(title);
        bookSearchDto.setBookSubtitle(subtitle);
        bookSearchDto.setAuthor(author);
        bookSearchDto.setDescription(description);

    ResponseEntity<GoogleBooks> response = restTemplate.exchange(
            API_URL + searchTerm +"&maxResults=1",
            HttpMethod.GET,
            request,
            GoogleBooks.class
    );
    GoogleBooks googleBooks = new GoogleBooks();
    googleBooks = response.getBody();
    System.out.println("did this work?");

    BookDto bookDto = new BookDto();
    Items[] items = googleBooks.getItems().toArray(new Items[0]);
    Items myItem = items[0];
    String myTitle = myItem.getVolumeInfo().getTitle();

        return bookSearchDto;
    }
}
