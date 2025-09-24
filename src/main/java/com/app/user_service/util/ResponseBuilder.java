package com.app.user_service.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseBuilder {

    public static <T> ResponseEntity<ApiResponse<T>> success(T data) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .status("success")
                .data(data)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, HttpStatus status) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .status("error")
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, status);
    }
}
