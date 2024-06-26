package com.luv2code.springboot.thymeleafdemo.security;

import com.luv2code.springboot.thymeleafdemo.repository.UserRepository;

import com.luv2code.springboot.thymeleafdemo.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByUsername(username);

        if (user != null) {
            return user;
        }

        throw new UsernameNotFoundException("User: " + username + " not found!");
    }

    
}