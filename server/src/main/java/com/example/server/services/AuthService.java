package com.example.server.services;

import com.example.server.dtos.SignInDto;
import com.example.server.dtos.SignUpDto;
import com.example.server.entities.User;
import com.example.server.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = repository.findByUsername(username);
        return user;
    }

    public UserDetails signUp(SignUpDto data) throws Exception {
        if (repository.findByUsername(data.username()) != null) {
            throw new Exception("Username already exists");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), encryptedPassword);
        return repository.save(newUser);
    }
}
