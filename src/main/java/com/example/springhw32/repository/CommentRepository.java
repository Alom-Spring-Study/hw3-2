package com.example.springhw32.repository;

import com.example.springhw32.dto.CommentDto;
import com.example.springhw32.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPostId(Long postId);
}
