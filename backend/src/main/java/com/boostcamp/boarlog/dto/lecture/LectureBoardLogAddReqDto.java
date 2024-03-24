package com.boostcamp.boarlog.dto.lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.nio.Buffer;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LectureBoardLogAddReqDto {
    private Buffer objects;
    private int[] viewport;
    private int eventTime;
    private int width;
    private int height;
}
