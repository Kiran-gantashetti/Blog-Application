package com.kiran.payloads;

import java.util.List;

import lombok.Data;

@Data
public class PostResponse {

	private List<PostDto> content;
	private int pageNumber;
	private int pageSize;
	private long totalElement;
	private int totalPages;
	private boolean lastpage;
	
}
