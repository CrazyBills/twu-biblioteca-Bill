package com.twu.biblioteca.views;

public class BorrowBookView implements BaseView {
    private final String type;

    public BorrowBookView(String type) {
        this.type = type;
    }

    @Override
    public String render() {
        return "please input the id of " + type + " you want to check out:";
    }
}
