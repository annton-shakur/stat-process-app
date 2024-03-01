package com.example.statprocessapplication.mapper;

import com.example.statprocessapplication.configuration.MapperConfig;
import com.example.statprocessapplication.dto.user.UserRegistrationRequestDto;
import com.example.statprocessapplication.dto.user.UserResponseDto;
import com.example.statprocessapplication.model.user.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toModel(UserRegistrationRequestDto requestDto);
}
