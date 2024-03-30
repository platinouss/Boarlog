package com.boostcamp.boarlog.service;

import com.boostcamp.boarlog.domain.User;
import com.boostcamp.boarlog.dto.auth.SignUpReqDto;
import com.boostcamp.boarlog.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RegisterServiceTest {

    private static final String EMAIL = "test@boarlog.com";
    private static final String USERNAME = "boarlog";
    private static final String PASSWORD = "0000";
    private final AuthService authService;
    private final UserRepository userRepository;

    @Autowired
    public RegisterServiceTest(AuthService authService, UserRepository userRepository) {
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @BeforeEach
    void registerInit() {
        authService.removeUser(EMAIL);
    }

    @Test
    @DisplayName("회원가입 요청")
    void registerSuccessTest() {
        SignUpReqDto signUpReqDto = SignUpReqDto.builder()
                .email(EMAIL)
                .username(USERNAME)
                .password(PASSWORD)
                .build();
        authService.addUser(signUpReqDto);
        User user = userRepository.findUserByEmail(EMAIL);
        assertEquals(USERNAME, user.getUsername());
    }

    @Test
    @DisplayName("이미 존재하는 이메일로 회원가입 요청")
    void registerFailTest() {}

}
