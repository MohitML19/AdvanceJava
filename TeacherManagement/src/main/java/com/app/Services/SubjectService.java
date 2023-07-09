package com.app.Services;

import java.util.List;

import com.app.DTO.SubjectDTO;
import com.app.Entity.Subject;

public interface SubjectService {

	List<Subject> getAllSubs();
	
	Subject insertSub(Subject b);
	
	Subject updateSub(Subject b);
	
	SubjectDTO insertSubject(SubjectDTO S);
	
	List<Subject> getByTeacherId(Long id);

	String deleteSub(Long id);
}
