package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.SubjectDTO;
import com.app.Entity.Subject;
import com.app.Services.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subser;
	
	@PostMapping("/dto")
	public SubjectDTO insertSDTO(@RequestBody  SubjectDTO s)
	{
		return subser.insertSubject(s);
	}
	
	@GetMapping("list")
	public List<Subject> getAll(){
		return subser.getAllSubs();
	}
	
	@GetMapping("/lists/{id}")
	public List<Subject> getSubs(@PathVariable Long id){
		return subser.getByTeacherId(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteSub(@PathVariable Long id) {
		return subser.deleteSub(id);
	}
	
}
