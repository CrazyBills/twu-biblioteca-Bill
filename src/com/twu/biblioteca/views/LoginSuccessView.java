package com.twu.biblioteca.views;

import com.twu.biblioteca.model.User;

public class LoginSuccessView implements BaseView{

    private final User loggedInUser;

    public LoginSuccessView(User loggedinUser) {
        this.loggedInUser = loggedinUser;
    }

    @Override
    public String render() {

        StringBuffer buffer = new StringBuffer();

        buffer.append("Login successfully!!\n");
        buffer.append(loggedInUser.toString());

        buffer.append("\n");

        return buffer.toString();
    }
}
