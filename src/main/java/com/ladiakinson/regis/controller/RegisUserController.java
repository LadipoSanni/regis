package com.ladiakinson.regis.controller;

import com.ladiakinson.regis.data.UserRegisterResponse;
import com.ladiakinson.regis.model.UserRegisterRequest;
import com.ladiakinson.regis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RegisUserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> registerUser(@RequestBody UserRegisterRequest users) {
        // Check if the user already exists
        if (userService.userExists(users.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new UserRegisterResponse("User already exists"));
        }

        // Register the user
        userService.registerUser(users);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new UserRegisterResponse("User registered successfully"));
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }


    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

