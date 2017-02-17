package com.twu.biblioteca.views;

import com.twu.biblioteca.model.Good;

public class BookDetailView implements BaseView {

    Good good;

    public BookDetailView(Good good) {
        this.good = good;
    }

    @Override
    public String render() {

        StringBuffer buffer = new StringBuffer();
        buffer.append(good.getBookDetails());
        buffer.append("\n\n");
        buffer.append("input any string to return previous menu!");
        return buffer.toString();
    }
}
