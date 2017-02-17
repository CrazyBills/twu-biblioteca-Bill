package com.twu.biblioteca.Service;

import com.twu.biblioteca.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserManagementServiceTest {

    UserManagementService userManagementService;

    @Before
    public void setUp() throws Exception {
        userManagementService = UserManagementService.getInstance();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldReturnUser1() {
        User shouldbe = new User("John", "usr-test", "123456", "xoxo@gmail.com", "010-1010101");
        User user = userManagementService.login("usr-test", "123456");

        assertEquals(shouldbe, user);
    }

    @Test
    public void shouldReturnNull() {

        User login = userManagementService.login("23", "123125");
        assertNull(login);
    }


}