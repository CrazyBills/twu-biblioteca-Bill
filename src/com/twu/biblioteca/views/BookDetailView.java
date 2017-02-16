package com.twu.biblioteca.views;

import com.twu.biblioteca.model.Book;

public class BookDetailView implements BaseView {

    Book book;

    public BookDetailView(Book book) {
        this.book = book;
    }

    @Override
    public String render() {

        StringBuffer buffer = new StringBuffer();

        buffer.append("Here are details of book ");

        buffer.append(book.getId());
        buffer.append(":\nID\tName\tAuthor\tPublished Years\n");

        buffer.append(book.getId());
        buffer.append("\t");
        buffer.append(book.getBookName());
        buffer.append("\t");
        buffer.append(book.getAuthor());
        buffer.append("\t");
        buffer.append(book.getPublished());

        buffer.append("\n\n");
        buffer.append("input any string to return previous menu!");

        return buffer.toString();
    }
}
