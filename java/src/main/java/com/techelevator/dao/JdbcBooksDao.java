package com.techelevator.dao;


import com.techelevator.model.Books;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcBooksDao implements BooksDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBooksDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Books createBook(Books book) {
        String sql = "INSERT INTO books (isbn, title, author, cover_image, description) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING book_id";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, book.getIsbn(), book.getTitle(),
                book.getAuthor(), book.getCoverImage(), book.getDescription());

        return getBookById(newId);
    }

    @Override
    public Books getBookById(int bookId) {
        Books book = null;
        String sql = "SELECT book_id, isbn, title, author, cover_image, description " +
                "FROM books WHERE book_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookId);
        if (results.next()) {
            book = mapRowToBook(results);
        }
        return book;
    }



    @Override
    public List<Books> findBooksByAuthor(String author) {
        List<Books> books = new ArrayList<>();
        String sql = "SELECT book_id, isbn, title, author, cover_image, description FROM books WHERE author = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, author);
        while (results.next()) {
            Books book = mapRowToBook(results);
            books.add(book);
        }
        return books;
    }
    @Override
    public boolean addBook(int bookId) {
        String sql = "INSERT INTO reading_activity (user_id, book_id, format, reading_time, notes, reading_partner_id, is_completed, is_favorite, bookmark_page_number) " +
                "VALUES (?, ?, NULL, 0, NULL, NULL, false, false, 0)";
        int rowsAffected = jdbcTemplate.update(sql, bookId);
        return rowsAffected == 1;
    }

    @Override
    public boolean isFavoriteOfUserId(int bookId, int userId) {
        String sql = "SELECT COUNT(*) FROM reading_activity WHERE user_id = ? AND book_id = ? AND is_favorite = true";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, userId, bookId);
        return count > 0;
    }
    private Books mapRowToBook(SqlRowSet row) {
        Books book = new Books();
        book.setBookId(row.getInt("book_id"));
        book.setIsbn(row.getInt("isbn"));
        book.setTitle(row.getString("title"));
        book.setAuthor(row.getString("author"));
        book.setCoverImage(row.getString("cover_image"));
        book.setDescription(row.getString("description"));
        return book;
    }
}
