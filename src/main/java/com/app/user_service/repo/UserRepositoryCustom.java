package com.app.user_service.repo;

import com.app.user_service.entity.User;

import java.util.List;

public interface  UserRepositoryCustom {
    List<User> findActiveUsersWithRoleUser();
}
