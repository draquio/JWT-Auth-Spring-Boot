package com.example.jwt.service;

import com.example.jwt.dto.AuthResponse;
import com.example.jwt.dto.LoginDTO;
import com.example.jwt.dto.RegisterDTO;

public interface AuthService {
    AuthResponse login(LoginDTO request);
    AuthResponse register(RegisterDTO request);
}
