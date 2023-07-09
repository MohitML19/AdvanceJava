package com.app.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDTO {
	@NotBlank(message = "Please enter subname")
	private String subname;
	@Positive(message = "Enter valid duration")
	private int duration;
	
	private String book;
	
	private String descr;
	@NotBlank
	private String assignedTeacher;
}
