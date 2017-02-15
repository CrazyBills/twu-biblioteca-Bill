package com.twu.biblioteca.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookDetailControllerTest {

    BookDetailController bookDetailController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {
        bookDetailController = new BookDetailController(1);
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

        String expectedString = "Here are details of book 1:\nID\tName\tAuthor\tPublished Years\n1\tJava Language\tGoodWeather\t2005\n";

        bookDetailController.index();

        assertEquals(expectedString, byteArrayOutputStream.toString());

    }

    @Test
    public void action() throws Exception {

    }

}