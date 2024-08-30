package com.draquio.jwt_api.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.draquio.jwt_api.models.User;

public interface IUserService {
    User findByUsername(String username);
    Page<User> GetAllUsersPaged(Pageable pageable);
}

