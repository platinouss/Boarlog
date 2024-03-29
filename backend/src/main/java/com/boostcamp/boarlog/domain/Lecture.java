package com.boostcamp.boarlog.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;

@Document
public class Lecture {

    @Id
    private ObjectId id;

    @NotBlank
    private String title;

    @NotNull
    private String description;

    @DocumentReference
    private User presenterId;

    @NotBlank
    private boolean isEnd;

    private String audioUrl;

    private Date startTime;

}
