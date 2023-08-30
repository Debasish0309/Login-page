package com.project.login.service;

import com.project.login.entity.User;

public interface UserService {
	
	User findByUsername(String username);
    User signUp(User user);
    User signIn(String username, String password);

}
