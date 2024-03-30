package com.boostcamp.boarlog.service;

import com.boostcamp.boarlog.dto.auth.SignUpReqDto;
import com.boostcamp.boarlog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public void addUser(SignUpReqDto signUpReqDto) {
        userRepository.insertUser(signUpReqDto);
    }

    public void removeUser(String email) {
        userRepository.deleteUser(email);
    }
}
