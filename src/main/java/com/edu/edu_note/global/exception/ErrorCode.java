package com.edu.edu_note.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 400 BAD_REQUEST
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "BadRequest", "입력값이 올바르지 않습니다."),

    // 404 NOT_FOUND
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "NotFound", "해당 회원을 찾을 수 없습니다."),

    // 500 INTERNAL_SERVER_ERROR
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "InternalServerError", "알 수 없는 오류가 발생했습니다.");

    private final HttpStatus httpStatus;
    private final String name;    // "BadRequest" 같은 에러 이름
    private final String message; // 상세 메시지
}