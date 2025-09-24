package com.app.user_service.repo;

import com.app.user_service.entity.UserHobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserHobbyRepository extends JpaRepository<UserHobby, Long> {
}