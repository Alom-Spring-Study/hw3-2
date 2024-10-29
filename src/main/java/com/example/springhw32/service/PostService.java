package com.example.springhw32.service;

import com.example.springhw32.dto.PostDto;
import com.example.springhw32.entity.Post;
import com.example.springhw32.entity.User;
import com.example.springhw32.repository.PostRepository;
import com.example.springhw32.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 글 작성
    public PostDto createPost(PostDto postDto, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NullPointerException::new);

        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setCommentCount(0);
        post.setPostedAt(LocalDateTime.now());
        post.setUser(user);
        postRepository.save(post);

        return postDto;
    }

    // 최신순으로 글 조회
    public List<PostDto> findAllPostsByOrderByPostedAtDesc() {
        return postRepository.findAllByOrderByPostedAtDesc().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 특정 회원이 작성한 글 조회
    public List<PostDto> findAllPostsByUserId(Long userId) {
        return postRepository.findAllByUserId(userId).stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // 댓글 많은 순으로 정렬 조회
    public List<PostDto> findAllPostsByOrderByCommentCountDesc() {
        return postRepository.findAllByOrderByCommentCountDesc().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    // Entity -> Dto
    private PostDto convertToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setCommentCount(post.getCommentCount());
        return postDto;
    }
}
