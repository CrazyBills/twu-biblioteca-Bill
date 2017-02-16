package com.twu.biblioteca.views;

public class ReturnBookView implements BaseView{

    @Override
    public String render() {
        return "please input the id of book you want to return:";
    }
}
