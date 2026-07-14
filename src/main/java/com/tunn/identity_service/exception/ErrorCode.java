package com.tunn.identity_service.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User existed"),
    USER_INVALID(1002, "Username must be at least 3 characters"),
    INVALID_MESSAGE(9999, "Invalid message key"),
    PASSWORD_INVALID(1003, "Password must be at least 8 characters"),
    USER_NOT_EXISTED(1004, "User not existed");


    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
