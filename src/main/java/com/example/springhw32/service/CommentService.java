package com.example.springhw32.service;

import com.example.springhw32.dto.CommentDto;
import com.example.springhw32.dto.PostDto;
import com.example.springhw32.dto.UserDto;
import com.example.springhw32.entity.Comment;
import com.example.springhw32.entity.Post;
import com.example.springhw32.entity.User;
import com.example.springhw32.repository.CommentRepository;
import com.example.springhw32.repository.PostRepository;
import com.example.springhw32.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    //댓글 작성
    public CommentDto createComments(CommentDto commentDto, Long userId, Long postId){
        User user = userRepository.findById(userId).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();

        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setPost(post);
        comment.setUser(user);
        commentRepository.save(comment);

        return commentDto;

    }
    //특정게시물의 모든댓글 조회
    public List<CommentDto> getCommentsByPostId(Long postId){
        return commentRepository.findAllByPostId(postId).stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());


    }

}
