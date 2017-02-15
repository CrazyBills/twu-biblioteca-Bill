package com.twu.biblioteca.model;

public class Book {

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    Integer id;

    public Book(Integer id, String bookName, String author, String published) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.published = published;
    }

    String bookName;
    String author;
    String published;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //simple Status 0 means unavailable;
    int status;
}
