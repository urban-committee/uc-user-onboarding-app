package com.urban.committee.payload.request;

import com.urban.committee.entity.Role;
import com.urban.committee.entity.UserCurrentAddress;
import com.urban.committee.entity.UserPermanentAddress;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UCOnboardingRequestPayload {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String gender;
    private int age;
    private String username;
    private String password;
    private boolean active;
    private boolean verified;
    private boolean multifa;
    private UserPermanentAddress permanentAddress;
    private UserCurrentAddress currentAddress;
    private final Set<Role> roles = new HashSet<>();
    private String createdby;
    private LocalDateTime createdOn;
}
