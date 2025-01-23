package com.kiran.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kiran.entity.Category;
import com.kiran.entity.Post;
import com.kiran.entity.User;

public interface PostRepo extends JpaRepository<Post , Integer> {

	List<Post> findByCategory(Category cat);

	List<Post> findByUser(User user);
	
	    @Query("SELECT p FROM Post p WHERE p.title LIKE %:key%")
	    List<Post>  findByTitleContaining(@Param("key") String keyword);
	



	
	

}
