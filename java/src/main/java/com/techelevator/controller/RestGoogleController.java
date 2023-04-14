package com.techelevator.controller;


import com.techelevator.model.dto.BookSearchDto;
import com.techelevator.service.RestGoogleBooksService;
import com.techelevator.service.RestGoogleBooksServiceImplementation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searchBy")
public class RestGoogleController {
    private RestGoogleBooksService restGoogleBooksService;
//injected restgooglebookservice interface
    public RestGoogleController(RestGoogleBooksService restGoogleBooksService){
        this.restGoogleBooksService = restGoogleBooksService;
    }
    //return book dto



 @RequestMapping(path = "/Isbn", method = RequestMethod.GET)
 public BookSearchDto getBooksByIsbn(){
        BookSearchDto bookSearchDto = new BookSearchDto();
        return bookSearchDto;
 }

    @RequestMapping(path = "/title", method = RequestMethod.GET)
    public BookSearchDto getBookSearchDto(){
        BookSearchDto bookSearchDto = new BookSearchDto();
        bookSearchDto = restGoogleBooksService.getBookSearchDto();
        return bookSearchDto;
    }
}
