package com.kiran.repositries;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiran.entity.Category;

public interface CategoryRepo extends JpaRepository<Category , Integer> {
    
	  Optional<Category> findById(Integer id);
	

}
