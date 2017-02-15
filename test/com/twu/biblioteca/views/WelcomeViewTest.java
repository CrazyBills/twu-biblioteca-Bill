package com.twu.biblioteca.views;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WelcomeViewTest {


    WelcomeView welcomeView;


    @Before
    public void initial(){
        welcomeView = new WelcomeView();
    }


    @Test
    public void shouldPrintWelcome(){

        assertEquals("Welcome to Library!\nPress any key to continue...",welcomeView.render() );
    }


}