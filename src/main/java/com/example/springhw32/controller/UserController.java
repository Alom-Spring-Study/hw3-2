package com.example.springhw32.controller;

import com.example.springhw32.dto.UserDto;
import com.example.springhw32.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    //회원가입
    @PostMapping("/signup")
    public UserDto signup(@ModelAttribute UserDto userDto) {
        return userService.signup(userDto);
    }
}
