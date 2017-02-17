package com.twu.biblioteca.views;

import com.twu.biblioteca.controller.BaseController;

import java.util.List;

public class MenuView implements BaseView {

    private final List<BaseController> menuList;

    public MenuView(List<BaseController> menuList) {

        this.menuList = menuList;
    }

    @Override
    public String render() {

        StringBuffer buffer = new StringBuffer();

        buffer.append("Welcome to Main Menu,Press your selection and enter:\n");

        final int[] i = {0};
        menuList.forEach(baseController -> {
            buffer.append(++i[0] + ". " + baseController.getDescription() + "\n");
        });

        buffer.append("Note that you can input 'q' to return to former menu, input 'quit' to quit");
        return buffer.toString();
    }
}
