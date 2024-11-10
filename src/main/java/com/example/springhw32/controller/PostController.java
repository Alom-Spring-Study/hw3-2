package com.example.springhw32.controller;

import com.example.springhw32.dto.CommentDto;
import com.example.springhw32.dto.PostDto;
import com.example.springhw32.dto.UserDto;
import com.example.springhw32.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @PostMapping("")
    public PostDto create(Long userId,
                          @ModelAttribute PostDto postDto){
        return postService.create(userId,postDto);
    }

    @GetMapping("")
    public List<PostDto> getRecentPosts(){

        return postService.getRecentPosts();

    }

    @GetMapping("/{writer}")
    public List<PostDto> getPostsByWriter(@PathVariable("writer")String nickName){
        return postService.getPostsByWriter(nickName);


    }

    @GetMapping("/comments")
    public List<PostDto> getPopularPosts(){

        return postService.getPopularPosts();
    }




}
