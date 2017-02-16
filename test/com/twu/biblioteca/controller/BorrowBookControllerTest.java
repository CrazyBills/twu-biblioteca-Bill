package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.BookStorageService;
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

public class BorrowBookControllerTest {


    BorrowBookController borrowBookController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {
        borrowBookController = new BorrowBookController();
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void destory() {
        System.setOut(printStream);
    }


    @Test
    public void index(){

        borrowBookController.index();

        String shouldbe = "please input the id of book you want to check out:\n";

        assertEquals(shouldbe,byteArrayOutputStream.toString());
    }

    @Test
    public void action() throws  UndefinedInputException, BookOperationFailException {

        BookStorageService bookStorageService = spy(BookStorageService.getInstance());
        Book book =  new Book(1,"Java Language","GoodWeather","2005");
        book.setStatus(1);
        when(bookStorageService.getBookById(1)).thenReturn(book);

        borrowBookController.bookStorageService = bookStorageService;

        BaseController action = borrowBookController.action("1");

        assertNull(action);

        assertEquals("Thank you! Enjoy the book\n\n",byteArrayOutputStream.toString());
    }

    @Test(expected = BookOperationFailException.class)
    public void shouldFailBorrowBooks() throws UndefinedInputException, BookOperationFailException {

        BookStorageService bookStorageService = spy(BookStorageService.getInstance());
        Book book =  new Book(1,"Java Language","GoodWeather","2005");
        book.setStatus(0);
        when(bookStorageService.getBookById(1)).thenReturn(book);

        borrowBookController.bookStorageService = bookStorageService;

        BaseController action = borrowBookController.action("1");

        assertNull(action);

    }

    @Test(expected = BookOperationFailException.class)
    public void shouldFailBorrowBooksWhenInputWrongID() throws UndefinedInputException, BookOperationFailException {

        BookStorageService bookStorageService = spy(BookStorageService.getInstance());

        when(bookStorageService.getBookById(1)).thenReturn(null);

        borrowBookController.bookStorageService = bookStorageService;

        BaseController action = borrowBookController.action("1");

        assertNull(action);

    }



}