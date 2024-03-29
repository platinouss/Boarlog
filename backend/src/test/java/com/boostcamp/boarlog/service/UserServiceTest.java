package com.boostcamp.boarlog.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Test
    @DisplayName("일치하는 패스워드로 로그인 요청")
    void loginSuccessTest() {}

    @Test
    @DisplayName("일치하지 않는 패스워드로 로그인 요청")
    void loginFailTest() {}

    @Test
    @DisplayName("회원가입 요청")
    void registerSuccessTest() {}

    @Test
    @DisplayName("이미 존재하는 이메일로 회원가입 요청")
    void registerFailTest() {}
    
    @Test
    @DisplayName("유저 정보 가져오기")
    void getUserInfoTest() {}

    @Test
    @DisplayName("수강한 강의 목록 리스트 요청")
    void getLectureListTest() {}

    @Test
    @DisplayName("닉네임 변경 요청")
    void changeNicknameTest() {}

}
