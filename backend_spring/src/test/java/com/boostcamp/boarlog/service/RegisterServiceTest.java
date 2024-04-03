package com.boostcamp.boarlog.service;

import com.boostcamp.boarlog.domain.User;
import com.boostcamp.boarlog.dto.auth.SignUpReqDto;
import com.boostcamp.boarlog.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterServiceTest {

    private static final String EMAIL = "test@boarlog.com";
    private static final String USERNAME = "boarlog";
    private static final String PASSWORD = "0000";

    private final AuthService authService;
    private final UserRepository userRepository;
    private final MockMvc mvc;
    private final ObjectMapper objectMapper;

    @Autowired
    public RegisterServiceTest(AuthService authService, UserRepository userRepository, MockMvc mvc, ObjectMapper objectMapper) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.mvc = mvc;
        this.objectMapper = objectMapper;
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
    void registerFailTest() throws Exception {
        SignUpReqDto signUpReqDto = SignUpReqDto.builder()
                .email(EMAIL)
                .username(USERNAME)
                .password(PASSWORD)
                .build();
        authService.addUser(signUpReqDto);
        mvc.perform(post("/auth/signup")
                        .content(objectMapper.writeValueAsString(signUpReqDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isConflict());
    }

}
