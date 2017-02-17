package com.twu.biblioteca.controller;

import com.twu.biblioteca.views.BaseView;
import com.twu.biblioteca.views.WelcomeView;

public class WelcomeController implements BaseController {

    public BaseController pressAnyKeyAction() {

        return new LoginController();
    }

    @Override
    public String getDescription() {
        return "welcome";
    }

    @Override
    public BaseView index() {
        return new WelcomeView();
    }

    @Override
    public BaseController action(String input) {
        if (input != null)
            return pressAnyKeyAction();
        else return null;
    }
}
