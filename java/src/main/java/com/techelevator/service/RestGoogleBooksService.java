package com.techelevator.service;

import com.techelevator.model.dto.BookDto;
import com.techelevator.model.dto.BookSearchDto;

public interface RestGoogleBooksService {

    BookDto getBookSearchDto(BookSearchDto bookSearchDto);


}
