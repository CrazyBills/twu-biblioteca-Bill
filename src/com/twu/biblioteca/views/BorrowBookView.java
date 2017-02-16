package com.twu.biblioteca.views;

public class BorrowBookView implements BaseView {
    @Override
    public String render() {
        return "please input the id of book you want to check out:";
    }
}
