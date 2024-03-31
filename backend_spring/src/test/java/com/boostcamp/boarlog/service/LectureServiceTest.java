package com.boostcamp.boarlog.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LectureServiceTest {

    @Test
    @DisplayName("강의 생성 요청")
    void createLectureTest() {}
    
    @Test
    @DisplayName("강의 시작 요청")
    void startForOpenedLectureTest() {}
    
    @Test
    @DisplayName("생성되지 않은 강의 시작 요청")
    void startForUnopenedLectureTest() {}

    @Test
    @DisplayName("열린 강의 입장 요청")
    void enterOpenedLectureTest() {}
    
    @Test
    @DisplayName("열리지 않은 강의 입장 요청")
    void enterUnopenedLectureTest() {}
    
    @Test
    @DisplayName("화이트보드 수정 데이터 추가 요청")
    void saveWhiteboardForOpenedLectureTest() {}
    
    @Test
    @DisplayName("열리지 않은 강의에 화이트보드 수정 데이터 추가 요청")
    void saveWhiteboardForUnopenedLectureTest() {}

    @Test
    @DisplayName("강의 종료 요청")
    void endOpenedLectureTest() {}

    @Test
    @DisplayName("이미 닫힌 강의 종료 요청")
    void endUnopenedLectureTest() {}
    
}
