package com.kiran.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min=4,message="username must be a minimum of  4 characters")
	private String name;
	@Email(message="your email is not valid ")
	private String email;
	@NotEmpty
	@Size(min=3,max=10,message="password must be min of 3 chars and maximu of 10 chars")
	
	private String password;
	@NotEmpty
	private String about;

}
