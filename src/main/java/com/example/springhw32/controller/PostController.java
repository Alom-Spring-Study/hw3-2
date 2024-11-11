package com.example.springhw32.controller;

import com.example.springhw32.dto.PostDto;
import com.example.springhw32.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    //글작성
    @PostMapping("")
    public PostDto save(PostDto postDto) {
        return postService.save(postDto);
    }

    //최신순으로 글 조회
    @GetMapping("")
    public List<PostDto> findAllByOrder() {
        return postService.findAllByOrderByCreatedAtDesc();
    }

    //작성자 글 조회
    @GetMapping("/writer")
    public List<PostDto> findByWriter(@PathVariable Long userId) {
        return postService.findAllByWriter(userId);
    }

    //댓글 많은 순 조회
    @GetMapping("/comments")
    public List<PostDto> findByCommentNumberDesc() {
        return postService.findAllByCommentNumberDesc();
    }
}
