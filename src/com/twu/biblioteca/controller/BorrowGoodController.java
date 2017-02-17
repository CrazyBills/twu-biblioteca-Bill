package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.views.BaseView;
import com.twu.biblioteca.views.BorrowBookView;

public class BorrowGoodController implements BaseController {

    GoodStorageService goodStorageService;
    String type;

    public BorrowGoodController(GoodStorageService goodStorageService) {
        this.goodStorageService = goodStorageService;
        this.type = goodStorageService.getStoredType();
    }

    @Override
    public String getDescription() {
        return "Borrow "+type;
    }

    @Override
    public BaseView index() {
        BorrowBookView borrowBookView = new BorrowBookView(type);

        return borrowBookView;
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException, OperationFailException {

        try {
            Integer id = Integer.parseInt(input);

            if (goodStorageService.borrowGoodId(id)) {

                System.out.println("Thank you! Enjoy the "+type+"\n");
                return null;
            } else {
                throw new OperationFailException("That "+type+" is not available.\n");
            }

        } catch (NumberFormatException e) {
            throw new UndefinedInputException();
        }
    }
}
