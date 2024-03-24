package com.boostcamp.boarlog.controllers;

import com.boostcamp.boarlog.dto.auth.SignInReqDto;
import com.boostcamp.boarlog.dto.auth.SignInResDto;
import com.boostcamp.boarlog.dto.auth.SignUpReqDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "auth", description = "로그인 및 회원가입 API")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Operation(
            summary = "유저 로그인",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(schema = @Schema(implementation = SignInResDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "user not found")
            }
    )
    @PostMapping("/signin")
    public void signIn(@RequestBody SignInReqDto signInReqDto) {}

    @Operation(
            summary = "유저 회원가입",
            responses = {
                    @ApiResponse(responseCode = "201", description = "success"),
                    @ApiResponse(responseCode = "409", description = "already registered user")
            }
    )
    @PostMapping("/signup")
    public void signUp(@RequestBody SignUpReqDto signUpReqDto) {}

}
