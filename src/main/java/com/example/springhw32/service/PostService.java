package com.example.springhw32.service;

import com.example.springhw32.dto.PostDto;
import com.example.springhw32.entity.Post;
import com.example.springhw32.repository.PostRepository;
import com.example.springhw32.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    //글 작성
    public PostDto save(PostDto postDto, Long userId) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setUser(userRepository.findById(userId).orElse(null));
        post.setCommentNumber(0);
        post.setCreatedAt(LocalDateTime.now());
        postRepository.save(post);
        return postDto;
    }

    //최신순으로 글 조회
    public List<PostDto> findAllByOrderByCreatedAtDesc() {
        List<PostDto> postDtos = postRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(this::EntityToDto).collect(Collectors.toList());
        return postDtos;
    }

    //특정 회원이 작성한 글 조회
    public List<PostDto> findAllByWriter(Long userId) {
        List<PostDto> postDtos = postRepository.findAllByUserId(userId).stream()
                .map(this::EntityToDto).collect(Collectors.toList());
        return postDtos;
    }

    //댓글이 많은 순으로 정렬 조회
    public List<PostDto> findAllByOrderByCommentNumberDesc() {
        List<PostDto> postDtos = postRepository.findAllByOrderByCommentNumberDesc().stream()
                .map(this::EntityToDto).collect(Collectors.toList());
        return postDtos;
    }

    private PostDto EntityToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setCommentNumber(post.getCommentNumber());
        return postDto;
    }
}
