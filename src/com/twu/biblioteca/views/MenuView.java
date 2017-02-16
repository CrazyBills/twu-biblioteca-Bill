package com.twu.biblioteca.views;

public class MenuView implements BaseView{
    @Override
    public String render() {
        return "Welcome to Main Menu,Press your selection and enter:\n1. List Books\n2. Borrow Books\n3. Return Books\n4. Quit";
    }
}
