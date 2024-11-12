package com.example.springhw32.controller;

import com.example.springhw32.dto.CommentDto;
import com.example.springhw32.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class CommentController {
    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/comments")
    public CommentDto addComment(@ModelAttribute CommentDto commentDto, @RequestParam Long postId) {
        return commentService.addComment(commentDto, postId);
    }

    //특정 게시물에 달린 모든 댓글 조회
    @GetMapping("/comments/postid")
    public List<CommentDto> getCommentByPostId(@PathVariable Long postId) {
        return commentService.getCommentByPostId(postId);
    }
}
