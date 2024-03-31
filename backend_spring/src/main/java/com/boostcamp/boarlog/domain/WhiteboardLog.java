package com.boostcamp.boarlog.domain;

import org.bson.types.ObjectId;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document
public class WhiteboardLog {

    @Id
    private ObjectId id;

    private DataBuffer objects;

    private List<Integer> viewport;

    private int eventTime;

    private int width;

    private int height;

    @DocumentReference
    private Lecture lectureId;
}
