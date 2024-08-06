package com.urban.committee.service.impl;

import com.urban.committee.entity.User;
import com.urban.committee.repository.UserRepository;
import com.urban.committee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public  class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public User createUser(User user) {
        userRepository.save(user);

        return user;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

}
