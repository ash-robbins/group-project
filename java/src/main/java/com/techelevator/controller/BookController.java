package com.techelevator.controller;

import com.techelevator.dao.*;
import com.techelevator.model.ReadingActivity;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import com.techelevator.model.Books;

import javax.validation.Valid;
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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to locate Book.");
        } else {
            return bookActivity;
        }
    }

    /**
     *
     *Get book by book id
     * @param id book id
     * @return book
     *
     */
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

    /**
     *
     * add book
     * @param books
     * @return new book
     */
   @ResponseStatus(HttpStatus.CREATED)
   @RequestMapping(path = "/addBook", method = RequestMethod.POST)
   public Books addBook(@Valid @RequestBody Books books ){
        return booksDao.createBook(books);
   }


    /**
     *
     * update book
     * @param books
     * @param id book id
     * @return updated book
     */
    @RequestMapping(path = "update/book/{id}", method = RequestMethod.PUT)
    public Books update(@Valid @RequestBody Books books, @PathVariable int id){
        Books updatedBook = booksDao.updateBook(books, id);
        if (updatedBook == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found.");
        } else {
            return updatedBook;
        }
   }

    /**
     *
     * delete book
     * @param id book id
     */

   @ResponseStatus(HttpStatus.NO_CONTENT)
   @RequestMapping(path = "delete/book/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable int id){
        booksDao.removeBook(id);
    }


}
