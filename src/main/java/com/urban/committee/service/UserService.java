package com.urban.committee.service;

import com.urban.committee.entity.User;

import java.util.Optional;

public interface UserService {


    User createUser(User user);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

