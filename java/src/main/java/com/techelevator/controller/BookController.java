package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.ReadingActivity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.techelevator.model.Books;

import java.security.Principal;
import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
@CrossOrigin

public class BookController {
    private ReadingActivityDao readingActivityDao;
    private PrizeDao prizeDao;
    private PrizeWinnerDao prizeWinnerDao;
    private BooksDao booksDao;
    private UserDao userDao;

    public BookController(ReadingActivityDao readingActivityDao, PrizeDao prizeDao, PrizeWinnerDao prizeWinnerDao, BooksDao booksDao, UserDao userDao) {
        this.readingActivityDao = readingActivityDao;
        this.prizeDao = prizeDao;
        this.prizeWinnerDao = prizeWinnerDao;
        this.booksDao = booksDao;
        this.userDao = userDao;
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
     * @param principal
     * @return list of users books
     */
    @RequestMapping(path = "books/listbooks", method = RequestMethod.GET)
   public List<Books> listBooksByLoggedInUser(Principal principal) {
        int loggedInUserId = userDao.findIdByUsername(principal.getName());
        List<Books> booksList = booksDao.listBooksByUserId(loggedInUserId);
        if (booksList == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Books list not found.");
        } else {
            return booksList;
        }
   }

}
