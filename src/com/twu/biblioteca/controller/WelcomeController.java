package com.twu.biblioteca.controller;

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
    public void index() {

        String messae = new WelcomeView().render();
        System.out.println(messae);
    }

    @Override
    public BaseController action(String input) {
        if (input != null)
            return pressAnyKeyAction();
        else return null;
    }
}
