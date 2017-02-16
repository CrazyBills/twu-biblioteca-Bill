package com.twu.biblioteca.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MenuControllerTest {

    MenuController menuController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {
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
                "1. List Books\n" +
                "2. Borrow Books\n" +
                "3. Return Books\n" +
                "Note that you can input 'q' to return to former menu, input 'quit' to quit\n";
        menuController.index();

        assertEquals(shouldReturn, byteArrayOutputStream.toString());

    }

    @Test
    public void shouldReturnListBookController() throws Exception {

        BaseController action = menuController.action("1");

        assertTrue(action instanceof BookListController);

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

        BaseController borrowBookController = menuController.action("2");
        assertTrue(borrowBookController instanceof BorrowBookController);
    }

    @Test
    public void shouldReturnReturnBookController() throws UndefinedInputException {
        BaseController returnBookController = menuController.action("3");
        assertTrue(returnBookController instanceof ReturnBookController);
    }

    @Test
    public void shouldReturnNull() throws UndefinedInputException {
        BaseController returnedNull = menuController.action("4");
        assertNull(returnedNull);
    }

}