package com.example.springhw32.dto;

import com.example.springhw32.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private int commentNumber;
}
