package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    public void contextLoads() {

        // 加密
        String encodedPassword = passwordEncoder.encode("222".trim());
        System.out.println(encodedPassword);
    }

}
