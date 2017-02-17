package com.twu.biblioteca.controller;

public interface BaseController {

    String getDescription();

    public void index();

    public BaseController action(String input) throws UndefinedInputException, OperationFailException;
}
