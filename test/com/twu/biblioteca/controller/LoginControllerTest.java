package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.UserManagementService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class LoginControllerTest {

    LoginController loginController;
    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial() {
        loginController = new LoginController();
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

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("ll-111\n12345\n".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);

        loginController.scanner = scanner;

        loginController.index();

        String shouldBe = "please input your library number:\nplease input your password:\n";

        assertEquals(shouldBe,byteArrayOutputStream.toString());

        assertEquals("ll-111",loginController.getId());

    }

    @Test(expected = OperationFailException.class)
    public void shoulefailaction() throws Exception {

        BaseController action = loginController.action("132");

    }

    @Test
    public void shouldReturnMenu() throws UndefinedInputException, OperationFailException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("usr-test\n123456\n".getBytes());
        Scanner scanner = new Scanner(byteArrayInputStream);

        loginController.scanner = scanner;

        loginController.index();

        BaseController action = loginController.action("");

        assertTrue(action instanceof MenuController);

        assertNotNull(UserManagementService.getInstance().getLoggedInUser());

    }





}