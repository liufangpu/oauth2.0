package com.example.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

   String selectPasswdByEmail(String email);

    String selectPasswdByPhone(String username);
}
