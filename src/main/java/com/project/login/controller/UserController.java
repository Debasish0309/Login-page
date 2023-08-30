package com.project.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.login.entity.User;
import com.project.login.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signUp(@RequestBody User user) {
        return userService.signUp(user);
    }

    @PostMapping("/signin")
    public User signIn(@PathVariable String username, @PathVariable String password) {
        return userService.signIn(username, password);
    }
}
