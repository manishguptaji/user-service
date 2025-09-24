package com.app.user_service.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String createUser() {
        return "User created successfully!";
    }

    public String updateUserInterests() {
        return "Updated successfully!";
    }

    public String updateUserSubscription() {
        return "Updated successfully!";
    }
}
