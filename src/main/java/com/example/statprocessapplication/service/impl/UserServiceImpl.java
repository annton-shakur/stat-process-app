package com.example.statprocessapplication.service.impl;

import com.example.statprocessapplication.dto.user.UserRegistrationRequestDto;
import com.example.statprocessapplication.dto.user.UserResponseDto;
import com.example.statprocessapplication.exception.RegistrationException;
import com.example.statprocessapplication.mapper.UserMapper;
import com.example.statprocessapplication.model.user.User;
import com.example.statprocessapplication.repository.UserRepository;
import com.example.statprocessapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    public static final String EMAIL_EXIST_MSG
            = "The user with the provided email already exists!";
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponseDto save(UserRegistrationRequestDto requestDto) {
        if (userRepository.findUserByEmail(requestDto.getEmail()) != null) {
            throw new RegistrationException(EMAIL_EXIST_MSG);
        }
        User user = userMapper.toModel(requestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
