package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.BookStorageService;

public class BorrowBookController implements BaseController{

    BookStorageService bookStorageService = new BookStorageService();


    @Override
    public void index() {

    }

    @Override
    public BaseController action(String input) throws UndefinedInputException {

        return null;
    }
}
