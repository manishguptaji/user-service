package com.app.user_service.repo;

import com.app.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom  {

    // Optional: find user by email for login / JWT auth
    Optional<User> findByEmail(String email);

    // Optional: find user by username
    Optional<User> findByUsername(String username);

    // Optional: check if email exists
    boolean existsByEmail(String email);

    // Optional: check if username exists
    boolean existsByUsername(String username);
}
