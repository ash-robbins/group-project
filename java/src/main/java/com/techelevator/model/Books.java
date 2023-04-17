package com.techelevator.model;

public class Books {
    private int bookId;
<<<<<<< HEAD
    private long isbn;
=======
    //TODO isbn needs to be changed from int to long
    private int isbn;
>>>>>>> 6984e50c3c0310366539ef5bfa23b9c7d40c9db4
    private String title;
    private String author;
    private String coverImage;
    private String description;

    public Books(int bookId, long isbn, String title, String author, String coverImage, String description) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.coverImage = coverImage;
        this.description = description;
    }

    public Books() {

    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", coverImage='" + coverImage + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
