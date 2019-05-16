package com.hfad.mvplogin;

import com.hfad.mvplogin.data.model.User;

import junit.framework.TestCase;

public class LoginViewTest extends TestCase {

    public void testUser(){


//        String email = "geertdepont@yahoo.com";
//        User user = new User(email, "password123");
//        assertEquals(user.getEmail(), email);
    }

    public void testUserPassword(){
        String password = "pass123";
        User user = new User("geertdepont@yahoo.com", password);
        assertEquals(user.getPassword(), password);
    }

}