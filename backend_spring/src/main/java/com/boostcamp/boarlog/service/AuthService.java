package com.boostcamp.boarlog.service;

import com.boostcamp.boarlog.dto.auth.SignUpReqDto;
import com.boostcamp.boarlog.exception.RequestException;
import com.boostcamp.boarlog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.boostcamp.boarlog.exception.ErrorCode.DUPLICATED_USER_EMAIL;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    public void addUser(SignUpReqDto signUpReqDto) {
        if (userRepository.findUserByEmail(signUpReqDto.getEmail()) != null) {
            throw new RequestException(DUPLICATED_USER_EMAIL);
        }
        userRepository.insertUser(signUpReqDto);
    }

    public void removeUser(String email) {
        userRepository.deleteUser(email);
    }
}
