package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.views.ReturnBookView;

public class ReturnGoodController implements BaseController {
    public ReturnGoodController(GoodStorageService goodStorageService) {
        this.goodStorageService = goodStorageService;
        this.type = goodStorageService.getStoredType();
    }

    GoodStorageService goodStorageService;

    String type;

    @Override
    public String getDescription() {
        return "Return "+type;
    }

    @Override
    public void index() {
        ReturnBookView returnBookView = new ReturnBookView(type);
        System.out.println(returnBookView.render());
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException, OperationFailException {

        try {
            Integer id = Integer.parseInt(input);

            if (goodStorageService.returnGoodById(id)) {
                System.out.println("Thank you for returning the " + type + ".\n");
                return null;
            } else {
                throw new OperationFailException("That is not a valid " + type + " to return.\n");
            }

        } catch (NumberFormatException e) {
            throw new UndefinedInputException();
        }

    }
}
