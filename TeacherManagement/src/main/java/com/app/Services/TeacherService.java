package com.app.Services;

import java.util.List;

import com.app.DTO.TeacherDTO;
import com.app.DTO.TeacherSignInDTO;
import com.app.Entity.Teacher;

public interface TeacherService  {

	List<Teacher> getAllTeachers();
	
	//Teacher addTeacher(Teacher t);
	
	Teacher updateTeacher(TeacherDTO t);
	
	String deleteTeacher(Long id);

	Teacher addTeacher(TeacherDTO t);
	
	Teacher signIn(TeacherSignInDTO td);
}
