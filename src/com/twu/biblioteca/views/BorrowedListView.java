package com.twu.biblioteca.views;

import com.twu.biblioteca.Service.UserManagementService;
import com.twu.biblioteca.model.Good;
import com.twu.biblioteca.model.User;

import java.util.List;

public class BorrowedListView implements BaseView {
    private final List<Good> checkedGoodList;

    UserManagementService userManagementService = UserManagementService.getInstance();

    public BorrowedListView(List checkedGoodLists) {
        this.checkedGoodList = checkedGoodLists;
    }

    @Override
    public String render() {

        StringBuffer buffer = new StringBuffer();

        buffer.append("Here are the checked list:\n");
        buffer.append("Name\tUser ID\tUser Name\tE-Mail\tPhone\n");

        checkedGoodList.stream().forEach(good -> {
            buffer.append(good.getName());
            buffer.append("\t");

            User userById = userManagementService.getUserById(good.getBorrowerID());

            buffer.append(userById.getAccount_id());
            buffer.append("\t");

            buffer.append(userById.getName());
            buffer.append("\t");

            buffer.append(userById.getEmail());
            buffer.append("\t");

            buffer.append(userById.getPhone());
            buffer.append("\n");
        });

        buffer.append("input 'q' to return to previous menu");

        return buffer.toString();
    }
}
