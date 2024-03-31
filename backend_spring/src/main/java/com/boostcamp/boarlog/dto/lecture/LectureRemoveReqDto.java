package com.boostcamp.boarlog.dto.lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LectureRemoveReqDto {
    private String code;
    private String audio;
}
