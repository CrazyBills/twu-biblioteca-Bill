package com.twu.biblioteca.views;



public class WelcomeView implements BaseView{
    public String render() {

        return "Welcome to Library!\n" +
                "input any string to continue...";

    }
}
