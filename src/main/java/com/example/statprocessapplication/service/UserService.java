package com.example.statprocessapplication.service;

import com.example.statprocessapplication.dto.user.UserRegistrationRequestDto;
import com.example.statprocessapplication.dto.user.UserResponseDto;

public interface UserService {
    UserResponseDto save(UserRegistrationRequestDto requestDto);
}
