package com.twu.biblioteca.views;

import com.twu.biblioteca.model.Good;

public class GoodDetailView implements BaseView {

    Good good;

    public GoodDetailView(Good good) {
        this.good = good;
    }

    @Override
    public String render() {

        StringBuffer buffer = new StringBuffer();
        buffer.append(good.getGoodDetails());
        buffer.append("\n\n");
        buffer.append("input any string to return previous menu!");
        return buffer.toString();
    }
}
