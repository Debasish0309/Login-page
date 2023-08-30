package com.project.login.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.login.entity.User;
import com.project.login.repository.UserRepository;
import com.project.login.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
	
	@Override
	public User signUp(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
	
	@Override
    public User signIn(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }
	
	 

}
