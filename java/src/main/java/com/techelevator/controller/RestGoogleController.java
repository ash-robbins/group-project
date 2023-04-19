package com.techelevator.controller;


import com.techelevator.model.dto.BookDto;
import com.techelevator.model.dto.BookSearchDto;
import com.techelevator.service.RestGoogleBooksService;
import com.techelevator.service.RestGoogleBooksServiceImplementation;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/searchBy")
public class RestGoogleController {
    private RestGoogleBooksService restGoogleBooksService;
//injected restgooglebookserviceinterface
    public RestGoogleController(RestGoogleBooksService restGoogleBooksService){
        this.restGoogleBooksService = restGoogleBooksService;
    }

    @RequestMapping(path = "/title/{searchTerm}/isbn/{searchIsbn}", method = RequestMethod.GET)
    public BookDto getBookSearchDto(@PathVariable(required = false) String searchTerm, @PathVariable(required = false) Long searchIsbn){
        BookSearchDto bookSearchDto = new BookSearchDto();
        bookSearchDto.setBookTitle(searchTerm);
        bookSearchDto.setBookisbn(searchIsbn);
        BookDto bookDto;
        bookDto = restGoogleBooksService.getBookSearchDto(bookSearchDto);
        return bookDto;
    }
}
