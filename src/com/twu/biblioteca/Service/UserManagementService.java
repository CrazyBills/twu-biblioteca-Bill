package com.twu.biblioteca.Service;

import com.twu.biblioteca.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserManagementService {

    private static UserManagementService instance;

    private Map<String,User> storage;

    public static UserManagementService getInstance() {

        if (instance == null) {
            instance = new UserManagementService();
        }
        return instance;
    }


    private UserManagementService(){

        storage = new HashMap<>();
        storage.put("usr-test",new User("John","usr-test","123456","xoxo@gmail.com","010-1010101"));
        storage.put("usr-admi",new User("Admin","usr-admi","654321","oxox@gmail.com","101-111000",true));
    }

    public User login(String id,String password){
        return null;
    }




}
