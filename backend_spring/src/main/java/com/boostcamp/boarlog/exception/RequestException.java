package com.boostcamp.boarlog.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RequestException extends RuntimeException {
    private final ErrorCode errorCode;
}
