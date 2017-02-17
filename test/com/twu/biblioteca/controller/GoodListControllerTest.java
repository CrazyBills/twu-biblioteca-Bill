package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.GoodStorageService;
import com.twu.biblioteca.model.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoodListControllerTest {

    GoodListController<Book> goodListController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {
        goodListController = new GoodListController(GoodStorageService.getBookInstance());
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
                "please Enter the id of book to explore the details";


        assertEquals(expectedString, goodListController.index().render());

    }

    @Test
    public void shouldReturnBookDetail1Controller() throws Exception {

        BaseController action = goodListController.action("1");

        assertTrue(action instanceof GoodDetailController);

        assertEquals(1, ((GoodDetailController) action).getGoodID().intValue());
    }

}