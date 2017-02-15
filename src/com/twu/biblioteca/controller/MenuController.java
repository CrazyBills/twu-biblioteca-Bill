package com.twu.biblioteca.controller;

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

        if(input.equals("1"))
            return  new BookListController();
        else throw new UndefinedInputException();
    }
}
