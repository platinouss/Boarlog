package com.boostcamp.boarlog.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignInResDto {
    private String token;
    private String email;
    private String username;
}
