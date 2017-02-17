package com.twu.biblioteca.views;

import com.twu.biblioteca.model.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginSuccessViewTest {
    @Test
    public void render() throws Exception {

        User user = new User("John", "usr-test", "123456", "xoxo@gmail.com", "010-1010101");

        LoginSuccessView successView = new LoginSuccessView(user);

        String shouldBe = "Login successfully!!\n" +
                "name='John', account_id='usr-test', email='xoxo@gmail.com', phone='010-1010101'\n" +
                "press 'Enter' to continue!";

        assertEquals(shouldBe, successView.render());

    }

}