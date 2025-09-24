package com.app.user_service.service;

import com.app.user_service.entity.Hobby;
import com.app.user_service.repo.HobbyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HobbyService {

    private final HobbyRepository hobbyRepository;

    public HobbyService(HobbyRepository hobbyRepository) {
        this.hobbyRepository = hobbyRepository;
    }

    public List<Hobby> getAllHobbies() {
        return hobbyRepository.findAll();
    }
}
