package com.app.Controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.TeacherDTO;
import com.app.DTO.TeacherSignInDTO;
import com.app.Entity.Teacher;
import com.app.Services.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	private TeacherService teachser;
	@Autowired
	private ModelMapper mp;
	
	@GetMapping
	public List<Teacher> getAllTs(){
		return teachser.getAllTeachers();
	}
	
	@PostMapping
	public Teacher addTeachers(@RequestBody  TeacherDTO t) {
		return teachser.addTeacher(t);
	}
	
	@PostMapping("/signin")
	public TeacherDTO getByEmail(@RequestBody @Valid TeacherSignInDTO dt) {
		Teacher t =teachser.signIn(dt);
		TeacherDTO t1 = mp.map(t, TeacherDTO.class);
		return t1;
		
	}
	@PutMapping
	public Teacher updateTeach(@RequestBody TeacherDTO t) {
		return teachser.updateTeacher(t);
	}
	
}
