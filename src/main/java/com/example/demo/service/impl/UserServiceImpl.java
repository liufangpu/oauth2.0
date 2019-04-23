package com.example.demo.service.impl;

import com.example.demo.entity.MyUserDetails;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service("userService")
public class UserServiceImpl implements UserService {



    private final static Set<User> users = new HashSet<>();

    static {
        users.add(new User(1, "test-user1", "$2a$10$.yCwd3M/RH9QL7XS1PAtnusCuext7qDWYzAk4DrvfHy76oLzhdMJ2"));
        users.add(new User(2, "test-user2", "666666"));
        users.add(new User(3, "test-user3", "$2a$10$.yCwd3M/RH9QL7XS1PAtnusCuext7qDWYzAk4DrvfHy76oLzhdMJ2"));
        users.add(new User(4, "test-user4", "$2a$10$.yCwd3M/RH9QL7XS1PAtnusCuext7qDWYzAk4DrvfHy76oLzhdMJ2"));
    }

    @Override
    public String selectPasswdByEmail(String email) {
        return "123465";
    }

    @Override
    public String selectPasswdByPhone(String username) {
        return "123456";
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = users.stream()
                .filter((u) -> u.getUsername().equals(s))
                .findFirst();
        if (!user.isPresent()){
            throw new UsernameNotFoundException("there's no user founded!");
        }else{
            return UserDetailConverter.convert(user.get());
        }
    }

    private static class UserDetailConverter {
        static UserDetails convert(User user) {
            return new MyUserDetails(user);
        }
    }
}
