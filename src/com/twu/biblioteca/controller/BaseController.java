package com.twu.biblioteca.controller;

public interface BaseController {

    public void index();

    public BaseController action(String input) throws UndefinedInputException, BookOperationFailException;
}
