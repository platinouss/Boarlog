package com.boostcamp.boarlog.controller;

import com.boostcamp.boarlog.dto.user.UserDetailsResDto;
import com.boostcamp.boarlog.dto.user.UserModifyReqDto;
import com.boostcamp.boarlog.dto.user.UserModifyResDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@Tag(name = "profile", description = "유저 프로필 API")
@RestController
@RequestMapping("/profile")
public class UserController {

    @Operation(
            summary = "유저 프로필 정보 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(schema = @Schema(implementation = UserDetailsResDto.class))
                    }),
                    @ApiResponse(responseCode = "401", description = "unauthorized user")
            }
    )
    @GetMapping()
    public void userDetails() {}

    @Operation(
            summary = "유저 프로필 정보(닉네임) 수정",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(schema = @Schema(implementation = UserModifyResDto.class))
                    }),
                    @ApiResponse(responseCode = "401", description = "unauthorized user")
            }
    )
    @PatchMapping()
    public void userModify(@RequestBody UserModifyReqDto userModifyRequestDto) {}

}
