package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.views.ReturnBookView;

public class ReturnGoodController implements BaseController {
    public ReturnGoodController(GoodStorageService goodStorageService) {
        this.goodStorageService = goodStorageService;
    }

    GoodStorageService goodStorageService;

    @Override
    public void index() {
        ReturnBookView returnBookView = new ReturnBookView();
        System.out.println(returnBookView.render());
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException, BookOperationFailException {

        try {
            Integer id = Integer.parseInt(input);

            if (goodStorageService.returnGoodById(id)) {
                System.out.println("Thank you for returning the book.\n");
                return null;
            } else {
                throw new BookOperationFailException("That is not a valid book to return.\n");
            }

        } catch (NumberFormatException e) {
            throw new UndefinedInputException();
        }

    }
}
