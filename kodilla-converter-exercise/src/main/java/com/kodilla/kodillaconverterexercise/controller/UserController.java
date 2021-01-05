package com.kodilla.kodillaconverterexercise.controller;

import com.kodilla.kodillaconverterexercise.domain.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/add")
    public void acceptCustomTextType(@RequestBody UserDto userDto) {
        System.out.println(userDto);
    }
}
