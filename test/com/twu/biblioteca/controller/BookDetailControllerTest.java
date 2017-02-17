package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookDetailControllerTest {

    GoodDetailController goodDetailController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {
        goodDetailController = new GoodDetailController(1, GoodStorageService.getBookInstance());
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

        String expectedString = "Here are details of book 1:\n" +
                "ID\tName\tAuthor\tPublished Years\n" +
                "1\tJava Language\tGoodWeather\t2005" +
                "\n\ninput any string to return previous menu!\n";

        goodDetailController.index();

        assertEquals(expectedString, byteArrayOutputStream.toString());

    }

    @Test
    public void action() throws Exception {

    }

}