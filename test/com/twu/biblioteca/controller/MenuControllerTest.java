package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.UserManagementService;
import com.twu.biblioteca.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuControllerTest {

    MenuController menuController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {

        try {
            Field loggedInUsers = UserManagementService.class.getDeclaredField("loggedInUser");
            loggedInUsers.setAccessible(true);
            loggedInUsers.set(UserManagementService.getInstance(), new User("John", "usr-test", "123456", "xoxo@gmail.com", "010-1010101"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

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

        String shouldReturn =  "Welcome to Main Menu,Press your selection and enter:\n" +
                "1. List Books\n" +
                "2. Borrow Books\n" +
                "3. Return Books\n" +
                "4. List Movies\n"+
                "5. Borrow Movies\n"+
                "6. Return Movies\n"+
                "Note that you can input 'q' to return to former menu, input 'quit' to quit\n";
        menuController.index();

        assertEquals(shouldReturn, byteArrayOutputStream.toString());

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

        BaseController borrowBookController = menuController.action("2");
        assertTrue(borrowBookController instanceof BorrowGoodController);
    }

    @Test
    public void shouldReturnReturnBookController() throws UndefinedInputException {
        BaseController returnBookController = menuController.action("3");
        assertTrue(returnBookController instanceof ReturnGoodController);
    }




    @Test
    public void shouldReturnListMovieController() throws Exception {

        BaseController action = menuController.action("4");

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