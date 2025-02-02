package com.kiran.services;

import java.util.List;

import com.kiran.payloads.PostDto;
import com.kiran.payloads.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
    PostDto updatePost(PostDto postDto, Integer postId);
    void deletePost(Integer postId);
    PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);
    PostDto getPostById(Integer postId);
    List<PostDto> getPostsByCategory(Integer categoryId);
    List<PostDto> getPostsByUser(Integer userId);
    List<PostDto> searchPosts(String keyword);
}
