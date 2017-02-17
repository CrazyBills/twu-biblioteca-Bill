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

public class BorrowGoodControllerTest {

    BorrowGoodController borrowGoodController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {
        borrowGoodController = new BorrowGoodController(GoodStorageService.getBookInstance());
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void destory() {
        System.setOut(printStream);
    }

    @Test
    public void index() {

        String shouldbe = "please input the id of book you want to check out:";

        assertEquals(shouldbe, borrowGoodController.index().render());
    }

    @Test
    public void action() throws UndefinedInputException, OperationFailException {

        GoodStorageService goodStorageService = spy(GoodStorageService.getBookInstance());
        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(1);
        when(goodStorageService.getGoodById(1)).thenReturn(book);

        borrowGoodController.goodStorageService = goodStorageService;

        BaseController action = borrowGoodController.action("1");

        assertNull(action);

        assertEquals("Thank you! Enjoy the book\n\n", byteArrayOutputStream.toString());
    }

    @Test(expected = OperationFailException.class)
    public void shouldFailBorrowBooks() throws UndefinedInputException, OperationFailException {

        GoodStorageService goodStorageService = spy(GoodStorageService.getBookInstance());
        Book book = new Book(1, "Java Language", "GoodWeather", "2005");
        book.setStatus(0);
        when(goodStorageService.getGoodById(1)).thenReturn(book);

        borrowGoodController.goodStorageService = goodStorageService;

        BaseController action = borrowGoodController.action("1");

        assertNull(action);

    }

    @Test(expected = OperationFailException.class)
    public void shouldFailBorrowBooksWhenInputWrongID() throws UndefinedInputException, OperationFailException {

        GoodStorageService goodStorageService = spy(GoodStorageService.getBookInstance());

        when(goodStorageService.getGoodById(1)).thenReturn(null);

        borrowGoodController.goodStorageService = goodStorageService;

        BaseController action = borrowGoodController.action("1");

        assertNull(action);

    }


}