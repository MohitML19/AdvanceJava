package com.app.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter

@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreType
public class Teacher extends BaseEntity{
	
	private String fname;
	
	private String lname;
	
	@Email
	@Column(unique = true,nullable = false)
	private String email;
	
	//@Pattern()
	@Column(nullable = false)
	private String password;
	
	private int age;
	
	
	private LocalDate dob;
	@OneToMany(mappedBy = "assignedTeacher" , cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Subject> slist;
	
	
	public boolean addSub(Subject s) {
		slist.add(s);
		s.setAssignedTeacher(this);
		return true;
	}
	
	public boolean removeSub(Subject s)
	{
		slist.remove(s);
		s.setAssignedTeacher(null);
		return true;
	}
}
