package com.app.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSignInDTO {
	@Email
	private String email;
	//@Pattern(regexp="^(=?*.[A-Za-z])(?[@#$%])(=?*./d).{8,}$")
	private String password;
}
