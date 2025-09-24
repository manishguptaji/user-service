package com.app.user_service.controller;

import com.app.user_service.dto.UserRequestDto;
import com.app.user_service.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class PublicUserController {

    private final UserService userService;

    public PublicUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody UserRequestDto dto) {
        String response = userService.createUser(dto);
        return ResponseEntity.ok(response);
    }
}

