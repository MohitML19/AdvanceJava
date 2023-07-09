package com.app.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDTO {

private String fname;
	
	private String lname;
	
	@Email
	private String email;
	
	private String password;
	@Positive
	private int age;
	
	
}
