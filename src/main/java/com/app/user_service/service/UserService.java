package com.app.user_service.service;

import com.app.user_service.dto.UserRequestDto;
import com.app.user_service.entity.User;
import com.app.user_service.entity.UserHobby;
import com.app.user_service.repo.UserHobbyRepository;
import com.app.user_service.repo.UserRepository;
import com.app.user_service.util.Role;
import com.app.user_service.util.Status;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserHobbyRepository userHobbyRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       UserHobbyRepository userHobbyRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userHobbyRepository = userHobbyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public String createUser(UserRequestDto dto) {

        String encodedPwd = passwordEncoder.encode(dto.getPassword());

        // 1️⃣ Save user
        User user = User.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(encodedPwd)
                .role(Role.USER)
                .status(Status.ACTIVE)
                .build();

        User savedUser = userRepository.save(user);

        // 2️⃣ Save user-hobbies entries
        List<UserHobby> userHobbies = dto.getHobbyIds().stream()
                .map(hobbyId -> UserHobby.builder()
                        .userId(savedUser.getId())
                        .hobbyId(hobbyId)
                        .build())
                .toList();

        userHobbyRepository.saveAll(userHobbies);

        return "User created successfully!";
    }
}

