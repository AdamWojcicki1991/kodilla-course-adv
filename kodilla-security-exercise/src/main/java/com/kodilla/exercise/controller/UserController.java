package com.kodilla.exercise.controller;

import com.kodilla.exercise.domain.UserDto;
import com.kodilla.exercise.mapper.UserMapper;
import com.kodilla.exercise.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping
class UserController {
    private final UserService service;

    @GetMapping("/m1")
    public List<UserDto> m1() {
        return UserMapper.toUserDtoList(service.getUsers());
    }

    @PostMapping("/m2")
    public void m2(@RequestBody UserDto userDto) {
        service.createUser(UserMapper.toUser(userDto));
    }

    @DeleteMapping("/m3")
    public void m3(@RequestBody UserDto userDto) {
        service.deleteUser(UserMapper.toUser(userDto));
    }
}
