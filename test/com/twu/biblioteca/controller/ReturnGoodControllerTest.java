package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ReturnGoodControllerTest {
    ReturnGoodController returnGoodController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {
        returnGoodController = new ReturnGoodController(GoodStorageService.getBookInstance());
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

        returnGoodController.index();
        assertEquals("please input the id of book you want to return:\n", byteArrayOutputStream.toString());
    }

    @Test
    public void action() throws Exception {
        GoodStorageService goodStorageService = spy(GoodStorageService.getBookInstance());
        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(0);
        when(goodStorageService.getGoodById(1)).thenReturn(book);
        returnGoodController.goodStorageService = goodStorageService;
        BaseController action = returnGoodController.action("1");
        assertNull(action);

        assertEquals("Thank you for returning the book.\n\n", byteArrayOutputStream.toString());
    }

    @Test(expected = BookOperationFailException.class)
    public void shouldFailReturnBooks() throws UndefinedInputException, BookOperationFailException {

        GoodStorageService goodStorageService = spy(GoodStorageService.getBookInstance());
        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(1);
        when(goodStorageService.getGoodById(1)).thenReturn(book);

        returnGoodController.goodStorageService = goodStorageService;

        BaseController action = returnGoodController.action("1");

        assertNull(action);

    }

    @Test(expected = BookOperationFailException.class)
    public void shouldFailReturnBooksWhenInputWrongID() throws UndefinedInputException, BookOperationFailException {

        GoodStorageService goodStorageService = spy(GoodStorageService.getBookInstance());

        when(goodStorageService.getGoodById(1)).thenReturn(null);

        returnGoodController.goodStorageService = goodStorageService;
        BaseController action = returnGoodController.action("1");

        assertNull(action);

    }

}