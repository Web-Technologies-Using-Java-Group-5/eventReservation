package com.univbuc.eventreservation.users.controllers;

import com.univbuc.eventreservation.users.model.User;
import com.univbuc.eventreservation.users.model.UserResponse;
import com.univbuc.eventreservation.users.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class Users {
    UserService userService;

    public Users(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> signUp(@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody User user){
        return ResponseEntity.ok(userService.login(user));
    }
}
