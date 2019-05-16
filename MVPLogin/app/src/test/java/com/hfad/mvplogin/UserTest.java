package com.hfad.mvplogin;

import junit.framework.TestCase;
import com.hfad.mvplogin.data.model.User;

import static org.junit.Assert.assertEquals;

public class UserTest extends TestCase {

    public void testUserEmail(){
        String email = "geertdepont@yahoo.com";
        User user = new User(email, "password123");
        assertEquals(user.getEmail(), email);
    }

    public void testUserPassword(){
        String password = "pass123";
        User user = new User("geertdepont@yahoo.com", password);
        assertEquals(user.getPassword(), password);
    }

}