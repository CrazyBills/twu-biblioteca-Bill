package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.BookStorageService;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.views.BookDetailView;

class BookDetailController implements BaseController {

    BookStorageService bookStorageService = BookStorageService.getInstance();
    private Integer bookID;

    public BookDetailController(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getBookID() {
        return bookID;
    }

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
