package com.example.statprocessapplication.controller;

import com.example.statprocessapplication.dto.user.UserLoginRequestDto;
import com.example.statprocessapplication.dto.user.UserLoginResponseDto;
import com.example.statprocessapplication.dto.user.UserRegistrationRequestDto;
import com.example.statprocessapplication.dto.user.UserResponseDto;
import com.example.statprocessapplication.exception.RegistrationException;
import com.example.statprocessapplication.security.AuthenticationService;
import com.example.statprocessapplication.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);
    }

    @PostMapping("/registration")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationRequestDto request)
            throws RegistrationException {
        return userService.save(request);
    }
}
