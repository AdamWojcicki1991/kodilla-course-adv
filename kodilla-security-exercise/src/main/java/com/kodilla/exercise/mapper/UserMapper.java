package com.kodilla.exercise.mapper;

import com.kodilla.exercise.domain.User;
import com.kodilla.exercise.domain.UserDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class UserMapper {

    public static User toUser(UserDto userDto) {
        return User.of(userDto.getLogin(), userDto.getEmail());
    }

    public static UserDto toUserDto(User user) {
        return new UserDto(user.getLogin(), user.getEmail());
    }

    public static List<User> toUserList(List<UserDto> userDtos) {
        return userDtos.stream().map(UserMapper::toUser).collect(toList());
    }

    public static List<UserDto> toUserDtoList(List<User> users) {
        return users.stream().map(UserMapper::toUserDto).collect(toList());
    }
}
