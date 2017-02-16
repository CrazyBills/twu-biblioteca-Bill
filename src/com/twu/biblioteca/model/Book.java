package com.twu.biblioteca.model;

public class Book {

    Integer id;
    String bookName;
    String author;
    String published;
    //simple Status 0 means unavailable;
    int status = 1;

    public Book(Integer id, String bookName, String author, String published) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.published = published;
    }

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!id.equals(book.id)) return false;
        if (!bookName.equals(book.bookName)) return false;
        if (!author.equals(book.author)) return false;
        return published.equals(book.published);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + bookName.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + published.hashCode();
        return result;
    }
}
