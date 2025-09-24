package com.app.user_service.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserRequestDto {
    private String username;
    private String email;
    private String password;
    private List<Long> hobbyIds;
}