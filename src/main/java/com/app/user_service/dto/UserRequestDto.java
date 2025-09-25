package com.app.user_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import java.util.List;

@Data
@Schema(description = "User creation request payload")
public class UserRequestDto {
    @Schema(description = "User's full name", example = "Manish Gupta")
    private String username;
    @Schema(description = "User's email address", example = "")
    private String email;
    private String password;
    private List<Long> hobbyIds;
}