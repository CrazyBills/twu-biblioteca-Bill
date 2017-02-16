package com.twu.biblioteca.views;

public class MenuView implements BaseView{
    @Override
    public String render() {
        return "Welcome to Main Menu,Press your selection and enter:\n" +
                "1. List Books\n" +
                "2. Borrow Books\n" +
                "3. Return Books\n" +
                "Note that you can input 'q' to return to former menu, input 'quit' to quit";
    }
}
