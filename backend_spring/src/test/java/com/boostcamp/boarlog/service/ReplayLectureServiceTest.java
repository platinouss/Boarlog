package com.boostcamp.boarlog.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReplayLectureServiceTest {

    @Test
    @DisplayName("강의 다시보기 요청")
    void lectureReplayTest() {}
    
    @Test
    @DisplayName("존재하지 않는 강의 다시 보기 요청")
    void nonexistentLectureReplayTest() {}

}
