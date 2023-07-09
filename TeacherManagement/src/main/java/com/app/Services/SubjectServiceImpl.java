package com.app.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.DTO.SubjectDTO;
import com.app.Entity.Subject;
import com.app.Entity.Teacher;
import com.app.Repository.SubjectRepository;
import com.app.Repository.TeacherRepository;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectRepository subRepo;
	@Autowired
	private TeacherRepository teachRepo;
	@Autowired
	private ModelMapper mp;
	//private SubjectService subser;
	
	@Override
	public List<Subject> getAllSubs() {
		// TODO Auto-generated method stub
		return subRepo.findAll();
	}

	@Override
	public Subject insertSub(Subject b) {
		// TODO Auto-generated method stub
		return subRepo.save(b);
	}

	@Override
	public Subject updateSub(Subject b) {
		// TODO Auto-generated method stub
		return subRepo.save(b);
	}

	@Override
	public SubjectDTO insertSubject(SubjectDTO s) {
		// TODO Auto-generated method stub
		Teacher t = teachRepo.findByfname(s.getAssignedTeacher());
		Subject s1 = mp.map(s, Subject.class);
		
		t.addSub(s1);
		Subject s2 = subRepo.save(s1);
		SubjectDTO sd = mp.map(s2, SubjectDTO.class);
		
		sd.setAssignedTeacher(t.getFname());
		
		
		return sd;
		
	}

	@Override
	public List<Subject> getByTeacherId(Long id) {
		// TODO Auto-generated method stub
		Teacher t1 = teachRepo.findById(id).orElseThrow();
		
		return t1.getSlist();
	}

	@Override
	public String deleteSub(Long id) {
		String msg = "Invalid id";
		Subject s = subRepo.findById(id).orElseThrow();
		s.getAssignedTeacher().removeSub(s);
		//if(s!=null) {
			//subRepo.deleteById(id);
			msg = "Subject deleted";
		//}
		return msg;
	}
	

	
	
	

}
