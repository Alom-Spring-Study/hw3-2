package com.example.springhw32.service;

import com.example.springhw32.dto.CommentDto;
import com.example.springhw32.entity.Comment;
import com.example.springhw32.entity.Post;
import com.example.springhw32.repository.CommentRepository;
import com.example.springhw32.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    //댓글 작성
    public CommentDto addComment(CommentDto commentDto, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setText(commentDto.getText());
        commentRepository.save(comment);

        post.setCommentNumber(post.getCommentNumber() + 1);
        postRepository.save(post);

        return commentDto;
    }

    //특정 개시물에 달린 모든 댓글 조회
    public List<CommentDto> getCommentByPostId(Long postId) {
        List<CommentDto> commentDtos = commentRepository.findAllByPostId(postId).stream()
                .map(this::EntityToDto).collect(Collectors.toList());
        return commentDtos;
    }

    private CommentDto EntityToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setText(comment.getText());
        return commentDto;
    }
}
