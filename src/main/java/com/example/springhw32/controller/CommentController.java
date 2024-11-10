package com.example.springhw32.controller;

import com.example.springhw32.dto.CommentDto;
import com.example.springhw32.dto.UserDto;
import com.example.springhw32.entity.User;
import com.example.springhw32.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts/comments")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("")
    public CommentDto createComments(@ModelAttribute CommentDto commentDto,Long userId, Long postId){

        return commentService.createComments(commentDto,userId,postId);
    }

    @GetMapping("/{postId}")
    public List<CommentDto> getCommentsByPostId(@PathVariable Long postId){
        return commentService.getCommentsByPostId(postId);

    }



}
