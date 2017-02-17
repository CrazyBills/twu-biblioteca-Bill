package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.model.Good;
import com.twu.biblioteca.views.BorrowBookView;

public class BorrowGoodController<T extends Good> implements BaseController {

    GoodStorageService<T> goodStorageService;

    public BorrowGoodController(GoodStorageService goodStorageService) {
        this.goodStorageService = goodStorageService;
    }

    @Override
    public void index() {
        BorrowBookView borrowBookView = new BorrowBookView();

        System.out.println(borrowBookView.render());
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException, BookOperationFailException {

        try {
            Integer id = Integer.parseInt(input);

            if (goodStorageService.borrowGoodId(id)) {
                System.out.println("Thank you! Enjoy the book\n");
                return null;
            } else {
                throw new BookOperationFailException("That book is not available.\n");
            }

        } catch (NumberFormatException e) {
            throw new UndefinedInputException();
        }
    }
}
