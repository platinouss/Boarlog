package com.boostcamp.boarlog.controllers;

import com.boostcamp.boarlog.dto.lecture.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "lecture", description = "강의 API")
@RestController
@RequestMapping("/lecture")
public class LectureController {

    @Operation(
            summary = "강의 정보 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(schema = @Schema(implementation = LectureDetailsResDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "lecture not found")
            }
    )
    @GetMapping()
    public void lectureDetails(@Parameter(name = "code", description = "강의 코드") @RequestParam String code) {}

    @Operation(
            summary = "강의 생성",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success"),
                    @ApiResponse(responseCode = "401", description = "unauthorized user")
            }
    )
    @PostMapping()
    public void lectureAdd(@RequestBody LectureAddReqDto lectureAddReqDto) {}

    @Operation(
            summary = "강의실 입장",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success"),
                    @ApiResponse(responseCode = "401", description = "unauthorized user"),
                    @ApiResponse(responseCode = "404", description = "lecture not found")
            }
    )
    @PatchMapping("/{code}")
    public void lectureModify(@Parameter(name = "code", description = "강의 코드") @PathVariable String code) {}

    @Operation(
            summary = "강의 종료",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success"),
                    @ApiResponse(responseCode = "404", description = "lecture not found")
            }
    )
    @PatchMapping("/end")
    public void lectureRemove(@RequestBody LectureRemoveReqDto lectureRemoveReqDto) {}

    @Operation(
            summary = "화이트보드 수정 데이터 추가",
            responses = {
                    @ApiResponse(responseCode = "201", description = "success"),
                    @ApiResponse(responseCode = "404", description = "lecture not found")
            }
    )
    @PostMapping("/log/{code}")
    public void lectureBoardLogAdd(
            @Parameter(name = "code", description = "강의 코드") @PathVariable String code,
            @Parameter(name = "lectureBoardLogAddReqDto", description = "화이트보드 데이터")
            @RequestBody LectureBoardLogAddReqDto lectureBoardLogAddReqDto
    ) {}


    @Operation(
            summary = "강의 자막 데이터 저장",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success"),
                    @ApiResponse(responseCode = "404", description = "lecture not found")
            }
    )
    @PostMapping("/{code}/text")
    public void lectureSubtitleAdd(
            @Parameter(name = "code", description = "강의 코드") @PathVariable String code,
            @RequestBody LectureSubtitleAddReqDto lectureSubtitleAddReqDto
    ) {}

    @Operation(
            summary = "강의 다시보기",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(schema = @Schema(implementation = LectureRecordDetailsResDto.class))
                    }),
                    @ApiResponse(responseCode = "404", description = "lecture not found")
            }
    )
    @PostMapping("/record/{id}")
    public void lectureRecordDetails(@Parameter(name = "id", description = "강의 고유 ID") @PathVariable String id) {}

    @Operation(
            summary = "수강한 강의 목록 조회",
            responses = {
                    @ApiResponse(responseCode = "200", description = "success", content = {
                            @Content(schema = @Schema(implementation = LectureListResDto.class))
                    }),
                    @ApiResponse(responseCode = "401", description = "unauthorized user")
            }
    )
    @GetMapping("/list")
    public void lectureList() {}
}
