package com.techelevator.controller;

import com.techelevator.dao.BooksDao;
import com.techelevator.dao.PrizeDao;
import com.techelevator.dao.PrizeWinnerDao;
import com.techelevator.dao.ReadingActivityDao;
import com.techelevator.model.ReadingActivity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.techelevator.model.Books;

@RestController
@PreAuthorize("isAuthenticated()")
public class BookController {
    private ReadingActivityDao readingActivityDao;
    private PrizeDao prizeDao;
    private PrizeWinnerDao prizeWinnerDao;
    private BooksDao booksDao;

    public BookController(ReadingActivityDao readingActivityDao, PrizeDao prizeDao, PrizeWinnerDao prizeWinnerDao, BooksDao booksdao) {
        this.readingActivityDao = readingActivityDao;
        this.prizeDao = prizeDao;
        this.prizeWinnerDao = prizeWinnerDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/books", method = RequestMethod.POST)
    public Books book (@RequestBody Books newBook) {
        Books bookActivity = booksDao.createBook(newBook);
        if (bookActivity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Reading Activity.");
        } else {
            return bookActivity;
        }
    }

    @RequestMapping(path = "/books/{book_id}", method = RequestMethod.GET)
    public Books getBookById (@PathVariable int bookId) {
        Books bookActivity = booksDao.getBookById(bookId);
        if (bookActivity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Reading Activity.");
        } else {
            return bookActivity;
        }
    }



}
