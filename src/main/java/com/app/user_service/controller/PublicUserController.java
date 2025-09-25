package com.app.user_service.controller;

import com.app.user_service.dto.UserRequestDto;
import com.app.user_service.entity.User;
import com.app.user_service.service.UserService;
import com.app.user_service.util.ApiResponse;
import com.app.user_service.util.ResponseBuilder;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PublicUserController {

    private final UserService userService;

    public PublicUserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create a new user")
    @PostMapping("/create-user")
    public ResponseEntity<ApiResponse<String>> createUser(@RequestBody UserRequestDto dto) {

        User user = userService.getUserByEmail(dto.getEmail());

        if (user != null) {
            return ResponseBuilder.error("User with this email already exists", org.springframework.http.HttpStatus.CONFLICT);
        }

        List<Long> hobbyIds = dto.getHobbyIds();

        if (hobbyIds == null || hobbyIds.isEmpty()) {
            return ResponseBuilder.error("At least one hobby must be selected", org.springframework.http.HttpStatus.BAD_REQUEST);
        }

        String response = userService.createUser(dto);
        return ResponseBuilder.success(response);
    }
}

