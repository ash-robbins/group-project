package com.techelevator.controller;


import com.techelevator.model.dto.BookSearchDto;
import com.techelevator.model.googlebooksapi.VolumeInfo;
import com.techelevator.service.RestGoogleBooks;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searchBy")
public class RestGoogleController {
    //return book dto

 @RequestMapping(path = "/Isbn", method = RequestMethod.GET)
 public BookSearchDto getBooksByIsbn(){
        BookSearchDto bookSearchDto = new BookSearchDto();
        return bookSearchDto;
 }

    @RequestMapping(path = "/title", method = RequestMethod.GET)
    public BookSearchDto getBookSearchDto(){
        BookSearchDto bookSearchDto = new BookSearchDto();
        return bookSearchDto;
    }
}
