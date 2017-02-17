package com.twu.biblioteca.views;

public class ReturnBookView implements BaseView {

    private final String type;

    public ReturnBookView(String type) {
        this.type = type;
    }

    @Override
    public String render() {
        return "please input the id of "+type+" you want to return:";
    }
}
