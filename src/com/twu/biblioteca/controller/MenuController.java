package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.model.Book;
import com.twu.biblioteca.views.BaseView;
import com.twu.biblioteca.views.MenuView;

public class MenuController implements BaseController {

    BaseView menuView = new MenuView();

    @Override
    public void index() {
        System.out.println(menuView.render());
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException {

        if (input.equals("1"))
            return new GoodListController<Book>(GoodStorageService.getBookInstance());
        else if (input.equals("2"))
            return new BorrowGoodController(GoodStorageService.getBookInstance());
        else if (input.equals("3"))
            return new ReturnGoodController(GoodStorageService.getBookInstance());
        else if (input.equals("4"))
            return null;
        else throw new UndefinedInputException();
    }
}
