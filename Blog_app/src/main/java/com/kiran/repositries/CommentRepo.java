package com.kiran.repositries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
