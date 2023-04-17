package com.techelevator.service;

import com.techelevator.model.dto.BookSearchDto;

public interface RestGoogleBooksService {

    BookSearchDto getBookSearchDto(String searchTerm);
}
