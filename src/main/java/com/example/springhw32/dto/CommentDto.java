package com.example.springhw32.dto;

import com.example.springhw32.entity.Comment;
import com.example.springhw32.entity.Post;
import com.example.springhw32.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    public CommentDto(Comment comment) {
        this.post = comment.getPost();
        this.user = comment.getUser();
        this.text = comment.getText();


    }

    @ManyToOne
    private Post post;

    @OneToOne
    private User user;

    private String text;

}
