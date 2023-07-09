package com.app.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.TeacherDTO;
import com.app.DTO.TeacherSignInDTO;
import com.app.Entity.Teacher;
import com.app.Repository.TeacherRepository;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teachRepo;
	@Autowired
	private ModelMapper mp ;
	
	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return teachRepo.findAll();
	}

	@Override
	public Teacher addTeacher(TeacherDTO t) {
		// TODO Auto-generated method stub
		Teacher t1= mp.map(t, Teacher.class);
		
		return teachRepo.save(t1);
		
	}
	

	@Override
	public Teacher updateTeacher(TeacherDTO t) {
		// TODO Auto-generated method stub
		Teacher t1  = mp.map(t, Teacher.class);
		return teachRepo.save(t1);
	}

	@Override
	public String deleteTeacher(Long id) {
		// TODO Auto-generated method stub
		String msg = "Invalid teacher";
		//Teacher t = teachRepo.findById(id).orElseThrow();
		if(teachRepo.existsById(id))
		{
			teachRepo.deleteById(id);
			msg="Teacher deleted";
		}	
		return msg;
	}

	@Override
	public Teacher signIn(TeacherSignInDTO td) {
		// TODO Auto-generated method stub
		Teacher t1 =  teachRepo.findByEmailAndPassword(td.getEmail(), td.getPassword());
		return t1;
		
	}
	
	

//	@Override
//	public Teacher addTeacher(Teacher t) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
}
