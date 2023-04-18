package com.techelevator.dao;
import com.techelevator.model.Books;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.awt.print.Book;
import java.util.List;
@CrossOrigin
public interface BooksDao {

    Books createBook(Books book);

    //Trello Get Book info from API TODO:link with api
    Books getBookById(int bookId);

    //Return Books by Author
    List<Books> findBooksByAuthor (String author);

    //Trello Add Book to current reading/userID/?
    boolean addBook (int bookId);

    //Trello isFavorite
    boolean isFavoriteOfUserId(int bookId, int userId);

    // ADDING FUNCTION TO LIST BOOKS BY USER -AR
    List<Books> listBooksByUserId(int userId);

    //ADD BOOK
    void addNewBook(Books books);

    //UPDATE BOOK
    Books updateBook(Books books, int bookId);

    //DELETE BOOK
    void removeBook(int bookId);





}
