package com.kiran.services;

import com.kiran.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto , Integer postId);
	void deleteComment(Integer commentId);

}
