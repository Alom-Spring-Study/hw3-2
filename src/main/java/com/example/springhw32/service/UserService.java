package com.example.springhw32.service;

import com.example.springhw32.dto.UserDto;
import com.example.springhw32.entity.User;
import com.example.springhw32.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserDto join(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setNickname(userDto.getNickname());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
        return userDto;
    }

}
