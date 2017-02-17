package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.model.Good;
import com.twu.biblioteca.views.BookDetailView;

class BookDetailController implements BaseController {

    GoodStorageService goodStorageService = GoodStorageService.getBookInstance();
    private Integer bookID;

    public BookDetailController(Integer bookID) {
        this.bookID = bookID;
    }

    public Integer getBookID() {
        return bookID;
    }

    @Override
    public void index() {
        Good good = goodStorageService.getBookById(this.bookID);
        BookDetailView bookDetailView = new BookDetailView(good);
        System.out.println(bookDetailView.render());
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException {
        return null;
    }
}
