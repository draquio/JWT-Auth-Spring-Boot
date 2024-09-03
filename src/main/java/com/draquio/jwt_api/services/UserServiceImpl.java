package com.draquio.jwt_api.services;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import org.apache.el.stream.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.draquio.jwt_api.dtos.userDTO.UserCreateDTO;
import com.draquio.jwt_api.dtos.userDTO.UserDetailDTO;
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
        return userRepository.findByUsername(username).orElseThrow();
    }


    @Override
    public Page<User> getAllUsersPaged(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable); 
        return users;
    }


    @Override
    public UserDetailDTO create(UserCreateDTO userCreateDTO) {
            User user = new User();
            user.setUsername(userCreateDTO.username);
            user.setEmail(userCreateDTO.email);
            user.setPassword(userCreateDTO.password);
            user.setCreatedAt(LocalDateTime.now());
    
            User userCreated = userRepository.save(user);
            UserDetailDTO userDetailDTO = new UserDetailDTO();
            if(userCreated != null){
                userDetailDTO.setEmail(userCreated.getEmail());
                userDetailDTO.setUsername(userCreateDTO.getUsername());
                userDetailDTO.setId(userCreated.getId());
            }
            return userDetailDTO;
    }

}
