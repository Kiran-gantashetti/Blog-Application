package com.kiran.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kiran.payloads.PostDto;
import com.kiran.payloads.PostResponse;
import com.kiran.services.FileService;
import com.kiran.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestParam("post") PostDto postDto,
            @RequestParam("image") MultipartFile image,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId) throws IOException {
        
        String imageName = fileService.uploadImage("post-images", image);
        postDto.setImageName(imageName);
        PostDto createdPost = postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {
		List<PostDto> posts = postService.getPostsByUser(userId);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {
		List<PostDto> posts = postService.getPostsByCategory(categoryId);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId) {
		PostDto post = postService.getPostById(postId);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

	@GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPosts(@RequestParam(value="pageNumber", defaultValue="0", required = false)Integer pageNumber,
    		@RequestParam(value="pageSize",defaultValue="5",required = false)Integer pageSize  ,
    		@RequestParam(value="sortBy",defaultValue = "postId",required = false)String sortBy,
    		@RequestParam(value="sortDir",defaultValue = "asc",required=false)String sortDir
    		) {
         PostResponse postResponse = postService.getAllPosts(pageNumber, pageSize, sortBy,sortDir);
        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }

	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId) {
		PostDto updatedPost = postService.updatePost(postDto, postId);
		return new ResponseEntity<>(updatedPost, HttpStatus.OK);
	}

	@DeleteMapping("/posts/{postId}")
	public ResponseEntity<Void> deletePost(@PathVariable Integer postId) {
		postService.deletePost(postId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/posts/search/{keyword}")
	public ResponseEntity<List<PostDto>> searchPosts(@PathVariable("keyword") String keyword) {
		List<PostDto> posts = this.postService.searchPosts( "%"+keyword+"%" );
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
}
