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

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin

public class BookController {
    private ReadingActivityDao readingActivityDao;
    private PrizeDao prizeDao;
    private PrizeWinnerDao prizeWinnerDao;
    private BooksDao booksDao;

    public BookController(ReadingActivityDao readingActivityDao, PrizeDao prizeDao, PrizeWinnerDao prizeWinnerDao, BooksDao booksDao) {
        this.readingActivityDao = readingActivityDao;
        this.prizeDao = prizeDao;
        this.prizeWinnerDao = prizeWinnerDao;
        this.booksDao = booksDao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/postbook", method = RequestMethod.POST)
    public Books book (@RequestBody Books newBook) {
        Books bookActivity = booksDao.createBook(newBook);
        if (bookActivity == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Reading Activity.");
        } else {
            return bookActivity;
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/books/{id}", method = RequestMethod.GET)
    public Books getBookById(@PathVariable int id) {
        Books book = new Books();
        book = booksDao.getBookById(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Book.");
        } else {
            return book;
        }
    }

    /**
     * List of books by user
     *
     * @param userId users id (may have to make it for THIS user? Principle?)
     * @return list of users books
     */
    @RequestMapping(path = "books/users/{id}", method = RequestMethod.GET)
   public List<Books> listBooksByUserId(@PathVariable("id") int userId) {
        List<Books> booksList = booksDao.listBooksByUserId(userId);
        if (booksList == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Books list not found.");
        } else {
            return booksList;
        }
   }



}
