package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.UserManagementService;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.views.BaseView;

import java.util.Scanner;

public class LoginController implements BaseController {

    public String getId() {
        return id;
    }

    private String id;

    private UserManagementService userManagementService = UserManagementService.getInstance();

    Scanner scanner = new Scanner(System.in);

    @Override
    public String getDescription() {
        return "login";
    }

    @Override
    public BaseView index() {
        userManagementService.logout();

        inputId();
        System.out.println("please input your password:");
        return null;
    }

    private void inputId() {
        System.out.println("please input your library number:");
        id = scanner.next();
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException, OperationFailException {


        User login = userManagementService.login(id, input);

        if (login != null) {
            return new MenuController();
        }
        throw new OperationFailException("login failed, check your id and password and try again!");
    }
}
