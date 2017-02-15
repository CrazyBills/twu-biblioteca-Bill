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
    public void initial(){
        menuController = new MenuController();
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void destory(){
        System.setOut(printStream);
    }

    @Test
    public void indexTest() throws Exception {

        String shouldReturn = "Welcome to Main Menu,Press your selection and enter:\n1. List Books\n";

        menuController.index();

        assertEquals(shouldReturn,byteArrayOutputStream.toString());

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

}