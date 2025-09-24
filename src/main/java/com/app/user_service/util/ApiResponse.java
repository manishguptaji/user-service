package com.app.user_service.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private String status;        // "success" or "error"
    private String message;       // optional message
    private T data;               // actual response
    private LocalDateTime timestamp;
}