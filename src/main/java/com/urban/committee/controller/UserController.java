package com.urban.committee.controller;

import com.urban.committee.entity.User;
import com.urban.committee.payload.request.UCOnboardingRequestPayload;
import com.urban.committee.payload.response.MessageResponse;
import com.urban.committee.service.impl.UserServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImplementation userService;

    @PostMapping("/userOnboarding")
    public ResponseEntity<?> registerUser(@Valid @Validated @RequestBody UCOnboardingRequestPayload userForOnboardingRequest) {
        if (userService.existsByUsername(userForOnboardingRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userService.existsByEmail(userForOnboardingRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }
        User user = getUser(userForOnboardingRequest);
        userService.createUser(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    private static User getUser(UCOnboardingRequestPayload userForOnboardingRequest) {
        User user = new User();
        user.setFirstname(userForOnboardingRequest.getFirstname());
        user.setLastname(userForOnboardingRequest.getLastname());
        user.setEmail(userForOnboardingRequest.getEmail());
        user.setPhone(userForOnboardingRequest.getPhone());
        user.setGender(userForOnboardingRequest.getGender());
        user.setCurrentAddress(userForOnboardingRequest.getCurrentAddress());
        user.setPermanentAddress(userForOnboardingRequest.getPermanentAddress());
        user.setAge(userForOnboardingRequest.getAge());
        user.setUsername(userForOnboardingRequest.getUsername());
        user.setPassword(userForOnboardingRequest.getPassword());
        user.setActive(userForOnboardingRequest.isActive());
        user.setVerified(userForOnboardingRequest.isVerified());
        user.setMultifa(userForOnboardingRequest.isMultifa());
        user.setRoles(userForOnboardingRequest.getRoles());
        return user;
    }
}

