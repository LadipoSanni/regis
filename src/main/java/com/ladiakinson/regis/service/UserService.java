package com.ladiakinson.regis.service;

import com.ladiakinson.regis.model.RegisUser;
import com.ladiakinson.regis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public RegisUser registerUser(RegisUser users) {
        if (userExists(users.getEmail())) {
            throw new IllegalStateException("User already exists");
        }
        return userRepository.save(users);
    }
}



