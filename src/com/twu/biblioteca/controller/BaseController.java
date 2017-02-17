package com.twu.biblioteca.controller;

import com.twu.biblioteca.views.BaseView;

public interface BaseController {

    String getDescription();

    public BaseView index();

    public BaseController action(String input) throws UndefinedInputException, OperationFailException;
}
