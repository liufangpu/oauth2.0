package com.example.demo.entity;

import java.util.Collections;

/**
 * 自定义UserDetails类 携带User实例
 */
public class MyUserDetails extends org.springframework.security.core.userdetails.User {

    private User user;

    public MyUserDetails(User user) {
        super(user.getUsername(), user.getPassword(), true, true, true, true, Collections.EMPTY_SET);
        this.user = user;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
}