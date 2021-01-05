package com.kodilla.kodillaconverter.controller;

import com.kodilla.kodillaconverter.domain.MyCustomClass;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/custom")
public class CustomController {

    @PostMapping(path = "/add")
    public void acceptCustomTextType(@RequestBody MyCustomClass customObject) {
        System.out.println(customObject.getFieldOne());
        System.out.println(customObject.getFieldTwo());
        System.out.println(customObject.getFieldThree());
    }
}
