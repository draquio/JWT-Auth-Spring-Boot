package com.draquio.jwt_api.services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.draquio.jwt_api.models.User;
import com.draquio.jwt_api.repositories.interfaces.IUserRepository;
import com.draquio.jwt_api.services.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }


    @Override
    public Page<User> GetAllUsersPaged(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

}
