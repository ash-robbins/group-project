package com.techelevator.service;

import com.google.gson.Gson;

import com.techelevator.model.dto.BookDto;
import com.techelevator.model.dto.BookGoogleDto;
import com.techelevator.model.dto.BookSearchDto;
import com.techelevator.model.googlebooksapi.GoogleBooks;
import com.techelevator.model.googlebooksapi.ImageLinks;
import com.techelevator.model.googlebooksapi.IndustryIdentifier;
import com.techelevator.model.googlebooksapi.Items;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.awt.print.Book;
import java.util.List;
import java.util.Map;

@Service
public class RestGoogleBooksServiceImplementation implements RestGoogleBooksService {
    private static final String API_KEY = "API_KEY";
    private static final String API_VALUE="AIzaSyCP7XUcC-GUKqAhetF1-kZrtzoh5HEO3QU";
    private static final String API_URL= "https://www.googleapis.com/books/v1/volumes?q=intitle:";
    private static final String API_URL_ISBN = "https://www.googleapis.com/books/v1/volumes?q=isbn:";

    private final RestTemplate restTemplate = new RestTemplate();

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
    public BookDto getBookSearchDto(BookSearchDto bookSearchDto) {
//        String searchTerm = "empire";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(API_KEY, API_VALUE);

        HttpEntity request = new HttpEntity(headers);
    ResponseEntity<GoogleBooks> response;

        if(bookSearchDto.getBookisbn() == null){

//            ResponseEntity<GoogleBooks>
                    response = restTemplate.exchange(
                    API_URL + bookSearchDto.getBookTitle() +"&maxResults=1",
                    HttpMethod.GET,
                    request,
                    GoogleBooks.class
            );
        } else {
//            ResponseEntity<GoogleBooks>
                    response = restTemplate.exchange(
                    API_URL_ISBN + bookSearchDto.getBookisbn() +"&maxResults=1",
                    HttpMethod.GET,
                    request,
                    GoogleBooks.class
            );
        }

    GoogleBooks googleBooks;
    googleBooks = response.getBody();
    BookDto bookDto = new BookDto();

    Items[] items = googleBooks.getItems().toArray(new Items[0]);
    Items myItem = items[0];

    List <IndustryIdentifier> industryIdentifier = myItem.getVolumeInfo().getIndustryIdentifiers();
    Long isbn = Long.parseLong (industryIdentifier.get(0).getIdentifier());
    bookDto.setIsbn(isbn);

    ImageLinks imageLinks = myItem.getVolumeInfo().getImageLinks();
    String imageLink = imageLinks.getThumbnail();
    bookDto.setImageLink(imageLink);

    bookDto.setTitle(myItem.getVolumeInfo().getTitle());
    bookDto.setDescription(myItem.getVolumeInfo().getDescription());

    List<String> myAuthors = myItem.getVolumeInfo().getAuthors();
    String formattedAuthors = authorFormatting(myAuthors);
    bookDto.setAuthor(formattedAuthors);

        return bookDto;
    }








    //Helper method
    private String authorFormatting(List<String> listAuthors){
        String combinedAuthors="";

        for(int i =0; i< listAuthors.size(); i++){

            if(i== listAuthors.size() - 1){
                combinedAuthors = combinedAuthors + listAuthors.get(i);
            }else{
                combinedAuthors = combinedAuthors + listAuthors.get(i) + " & ";
            }
        }
        return combinedAuthors;

    }

}
