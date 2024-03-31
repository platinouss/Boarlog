package com.boostcamp.boarlog.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class LectureCode {

    @Id
    private ObjectId id;

    @NotBlank
    @Size(min = 0, max = 999999)
    private int code;

    @DocumentReference
    private Lecture lectureId;
}
