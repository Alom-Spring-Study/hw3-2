package com.example.springhw32.service;

import com.example.springhw32.dto.CommentDto;
import com.example.springhw32.dto.PostDto;
import com.example.springhw32.entity.Comment;
import com.example.springhw32.entity.Post;
import com.example.springhw32.repository.CommentRepository;
import com.example.springhw32.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 댓글 작성
    public CommentDto addComment(CommentDto commentDto, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(NullPointerException::new);

        Comment comment = new Comment();
        comment.setComment(commentDto.getComment());
        comment.setPost(post);
        commentRepository.save(comment);

        post.setCommentCount(post.getCommentCount() + 1);
        postRepository.save(post);

        return commentDto;
    }

    // 특정 게시글에 작성된 댓글 조회
    public List<CommentDto> getAllComments(Long postId) {
        return commentRepository.findAllByPostId(postId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Entity -> Dto
    private CommentDto convertToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setComment(comment.getComment());
        return commentDto;
    }
}
