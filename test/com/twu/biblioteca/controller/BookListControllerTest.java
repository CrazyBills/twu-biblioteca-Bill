package com.twu.biblioteca.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookListControllerTest {

    BookListController bookListController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {
        bookListController = new BookListController();
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void destory() {
        System.setOut(printStream);
    }

    @Test
    public void index() throws Exception {

        String expectedString = "Here are list of books:\n" +
                "ID\tName\n" +
                "1\tJava Language\n" +
                "2\tGame Of Thrones\n" +
                "3\tAngularJS\n" +
                "4\tComputer Architecture\n" +
                "5\tFalling Slowly\n" +
                "please Enter the id of book to explore the details\n";

        bookListController.index();
        assertEquals(expectedString, byteArrayOutputStream.toString());

    }

    @Test
    public void shouldReturnBookDetail1Controller() throws Exception {

        BaseController action = bookListController.action("1");

        assertTrue(action instanceof BookDetailController);

        assertEquals(1, ((BookDetailController) action).getBookID().intValue());
    }

}