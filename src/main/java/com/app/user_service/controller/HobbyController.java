package com.app.user_service.controller;

import com.app.user_service.entity.Hobby;
import com.app.user_service.service.HobbyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.user_service.util.ApiResponse;
import com.app.user_service.util.ResponseBuilder;

import java.util.List;

@RestController
@RequestMapping("/hobbies")
public class HobbyController {

    private final HobbyService hobbyService;

    public HobbyController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Hobby>>> getAllHobbies() {
        List<Hobby> hobbies = hobbyService.getAllHobbies();

        if (hobbies.isEmpty()) {
            return ResponseBuilder.error("No hobbies found", HttpStatus.NO_CONTENT);
        }

        return ResponseBuilder.success(hobbies);
    }
}