package com.twu.biblioteca.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuControllerTest {

    MenuController menuController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {

        Initializer.initialUser();

        menuController = new MenuController();

        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void destory() {
        System.setOut(printStream);
    }

    @Test
    public void indexTest() throws Exception {

        String shouldReturn = "Welcome to Main Menu,Press your selection and enter:\n" +
                "1. List books\n" +
                "2. List movies\n" +
                "3. Borrow book\n" +
                "4. Return book\n" +
                "5. Borrow movie\n" +
                "6. Return movie\n" +
                "Note that you can input 'q' to return to former menu, input 'quit' to quit";

        assertEquals(shouldReturn, menuController.index().render());

    }

    @Test
    public void shouldReturnListBookController() throws Exception {

        BaseController action = menuController.action("1");

        assertTrue(action instanceof GoodListController);

    }

    @Test(expected = UndefinedInputException.class)
    public void shouldThrowUndefinedInputException23() throws UndefinedInputException {
        menuController.action("23");
    }

    @Test(expected = UndefinedInputException.class)
    public void shouldThrowUndefinedInputExceptiona() throws UndefinedInputException {
        menuController.action("a");
    }

    @Test
    public void shouldReturnBorrowBookController() throws UndefinedInputException {

        BaseController borrowBookController = menuController.action("3");
        assertTrue(borrowBookController instanceof BorrowGoodController);
    }

    @Test
    public void shouldReturnReturnBookController() throws UndefinedInputException {
        BaseController returnBookController = menuController.action("4");
        assertTrue(returnBookController instanceof ReturnGoodController);
    }

    @Test
    public void shouldReturnListMovieController() throws Exception {

        BaseController action = menuController.action("2");

        assertTrue(action instanceof GoodListController);

    }

    @Test
    public void shouldReturnBorrowMovieController() throws UndefinedInputException {

        BaseController borrowBookController = menuController.action("5");
        assertTrue(borrowBookController instanceof BorrowGoodController);
    }

    @Test
    public void shouldReturnReturnMovieController() throws UndefinedInputException {
        BaseController returnBookController = menuController.action("6");
        assertTrue(returnBookController instanceof ReturnGoodController);
    }


}