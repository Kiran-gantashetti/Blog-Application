package com.kiran.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.kiran.entity.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
    private Integer postId;
    private String title; // Corrected field name
    private String content;
    private String imageName;
    private Date addedDate;
    private Integer categoryId;
    private Integer userId;
    private Set<CommentDto> comments = new HashSet<>();
}
