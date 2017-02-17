package com.twu.biblioteca.controller;

import com.twu.biblioteca.Service.UserManagementService;
import com.twu.biblioteca.model.User;

import java.lang.reflect.Field;

public class Initializer {
    public Initializer() {
    }

    public static void initialUser() {
        try {
            Field loggedInUsers = UserManagementService.class.getDeclaredField("loggedInUser");
            loggedInUsers.setAccessible(true);
            loggedInUsers.set(UserManagementService.getInstance(), new User("John", "usr-test", "123456", "xoxo@gmail.com", "010-1010101"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}