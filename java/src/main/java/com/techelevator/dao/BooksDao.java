package com.techelevator.dao;
import com.techelevator.model.Books;

import java.util.List;

public interface BooksDao {

    Books createBook(Books book);

    //Trello Get Book info from API TODO:link with api
    Books getBookByIsbn(int isbn);

    //Return Books by Author
    List<Books> findBooksByAuthor (String author);

    //Trello Add Book to current reading/userID/?
    boolean addBook (int bookId);

    //Trello isFavorite
    boolean isFavoriteOfUserId(int bookId, int userId);
}
