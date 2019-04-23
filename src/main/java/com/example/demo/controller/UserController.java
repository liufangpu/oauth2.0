package com.example.demo.controller;

import com.example.demo.entity.MyUserDetails;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
 
    @Autowired
    private TokenStore tokenStore;
 
    @PostMapping("/bar")
    public String bar(@RequestHeader(name = "Authorization") String auth) {
        System.out.println("进入controller");
        MyUserDetails userDetails = (MyUserDetails) tokenStore.readAuthentication(auth.split(" ")[1]).getPrincipal();
 
        User user = userDetails.getUser();
 
        return user.getUsername() + ":" + user.getPassword();
    }
}