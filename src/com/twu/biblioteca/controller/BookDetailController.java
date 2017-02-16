package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.BookStorageService;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.views.BookDetailView;

class BookDetailController implements BaseController {

    public BookDetailController(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getBookID() {
        return bookID;
    }

    private Integer bookID;

    BookStorageService bookStorageService = BookStorageService.getInstance();

    @Override
    public void index() {
        Book book = bookStorageService.getBookById(this.bookID);
        BookDetailView bookDetailView = new BookDetailView(book);
        System.out.println(bookDetailView.render());
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException {
        return null;
    }
}
