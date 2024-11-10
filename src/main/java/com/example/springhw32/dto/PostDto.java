package com.example.springhw32.dto;

import com.example.springhw32.entity.Post;
import com.example.springhw32.entity.User;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PostDto {
    public PostDto(Post post) {
        this.user = post.getUser();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.commentCnt = post.getCommentCnt();
        this.createdAt = post.getCreatedAt();

    }
    @ManyToOne
    private User user;

    private String title;
    private String content;
    private Long commentCnt;
    private LocalDateTime createdAt;

}
