package com.nikhilgadiwadd.student_subject_management.jwt;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Repository
@Getter
@Setter
@Data
public class LoginRequest {
    private String username;

    private String password;
}
