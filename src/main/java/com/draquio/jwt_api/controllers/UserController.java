package com.draquio.jwt_api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.draquio.jwt_api.dtos.response.Response;
import com.draquio.jwt_api.dtos.userDTO.UserCreateDTO;
import com.draquio.jwt_api.dtos.userDTO.UserDetailDTO;
import com.draquio.jwt_api.models.User;
import com.draquio.jwt_api.services.interfaces.IUserService;

import jakarta.validation.Valid;

import org.hibernate.mapping.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Response<Page<User>>> GetAllUsersPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize){

        var response = new Response<Page<User>>();

        Pageable pageable = PageRequest.of(page, pageSize);
        Page<User> users = userService.getAllUsersPaged(pageable);

        response.setStatus(true);
        response.setMsg("Paged User list");
        response.setValue(users);
        return ResponseEntity.ok(response);
    }
    
    @PostMapping
    public ResponseEntity<Response<UserDetailDTO>> Create(@RequestBody @Valid UserCreateDTO userCreateDTO){
        var response = new Response<UserDetailDTO>();

        UserDetailDTO userDetailDTO = userService.create(userCreateDTO);
        response.setStatus(true);
        response.setValue(userDetailDTO);
        response.setMsg("User created successfully");
        return ResponseEntity.ok(response);
    }
    

}
