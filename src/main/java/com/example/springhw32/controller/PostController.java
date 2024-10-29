package com.example.springhw32.controller;

import com.example.springhw32.dto.PostDto;
import com.example.springhw32.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    // 글 등록
    @PostMapping
    public PostDto createPost(@ModelAttribute PostDto postDto, Long userId) {
        return postService.createPost(postDto, userId);
    }

    // 최신순으로 글 조회
    @GetMapping
    public List<PostDto> findAllPostsByOrderByPostedAtDesc() {
        return postService.findAllPostsByOrderByPostedAtDesc();
    }

    // 작성자 글 조회
    @GetMapping("/{writer}")
    public List<PostDto> findAllPostsByWriter(@PathVariable("writer") Long userId) {
        return postService.findAllPostsByUserId(userId);
    }

    // 댓글 많은 순으로 글 조회
    @GetMapping("/comments")
    public List<PostDto> findAllPostsByOrderByCommentCountDesc() {
        return postService.findAllPostsByOrderByCommentCountDesc();
    }
}
