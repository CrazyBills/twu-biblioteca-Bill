package com.twu.biblioteca.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WelcomeControllerTest {

    WelcomeController welcomeController;

    ByteArrayOutputStream byteArrayOutputStream;
    PrintStream printStream;

    @Before
    public void initial(){
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = System.out;
        welcomeController = new WelcomeController();
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void destory(){
        System.setOut(printStream);
    }

    @Test
    public void shouldReturnMenuController(){

        BaseController baseController = welcomeController.pressAnyKeyAction();

        assertTrue(baseController instanceof MenuController);

    }


    @Test
    public void shouldReturnNull(){
        assertEquals(null,welcomeController.action(null));
    }

    @Test
    public void shouldReturnMenuController1(){
        BaseController baseController = welcomeController.action("t");
        assertTrue(baseController instanceof MenuController);
    }

    @Test
    public void shouldPrintWelcomeMessage(){

        welcomeController.index();

        assertEquals("Welcome to Library!\nPress any key to continue...\n",byteArrayOutputStream.toString());

    }

}