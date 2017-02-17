package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.UserManagementService;
import com.twu.biblioteca.model.User;
import com.twu.biblioteca.views.BaseView;
import com.twu.biblioteca.views.LoginSuccessView;

import java.util.Scanner;

public class LoginController implements BaseController {

    Scanner scanner = new Scanner(System.in);
    private String password;
    private Boolean isLoggedIn = false;
    private String id;

    private UserManagementService userManagementService = UserManagementService.getInstance();

    public String getId() {
        return id;
    }

    @Override
    public String getDescription() {
        return "login";
    }

    @Override
    public BaseView index() {
        isLoggedIn = false;

        userManagementService.logout();

        inputId();
        inputPassword();

        User loggedinUser = userManagementService.login(id, this.password);

        if (loggedinUser != null) {
            isLoggedIn = true;
            return new LoginSuccessView(loggedinUser);
        }

        return null;
    }

    private void inputId() {
        System.out.println("please input your library number:");
        id = scanner.nextLine();
    }

    private void inputPassword() {
        System.out.println("please input your password:");
        this.password = scanner.nextLine();
    }

    @Override
    public BaseController action(String input) throws UndefinedInputException, OperationFailException {

        if (isLoggedIn) {
            return new MenuController();
        }

        if (id.equals("q") || password.equals("q")) return null;

        throw new OperationFailException("login failed, check your id and password and try again!");
    }
}
