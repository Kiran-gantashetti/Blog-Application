package com.kiran.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kiran.repositries.UserRepo;

@SpringBootTest
public class BlogAppApisApplicationTests {
	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextloads()
	{
		
	}
	
	@Test
	public void repoTest()
	{
		String className = this.userRepo.getClass().getName();
		String packname= this.userRepo.getClass().getPackageName();
		System.out.println(className);
		System.out.println(packname);
	}

}
