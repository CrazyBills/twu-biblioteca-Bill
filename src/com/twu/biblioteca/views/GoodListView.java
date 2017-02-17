package com.twu.biblioteca.views;

import com.twu.biblioteca.model.Good;

import java.util.List;

public class GoodListView<T extends Good> implements BaseView {

    List<T> goodList;
    private String type;

    public void setGoodList(List<T> goodList) {
        this.goodList = goodList;
    }

    @Override
    public String render() {

        StringBuffer resultBuffer = new StringBuffer();

        resultBuffer.append("Here are list of " + type + "s:\nID\tName\n");

        goodList.stream().forEach(good -> {
            resultBuffer.append(good.getId());
            resultBuffer.append("\t");
            resultBuffer.append(good.getName());
            resultBuffer.append("\n");
        });

        resultBuffer.append("please Enter the id of " + type + " to explore the details");

        return resultBuffer.toString();
    }

    public void setType(String type) {
        this.type = type;
    }
}
