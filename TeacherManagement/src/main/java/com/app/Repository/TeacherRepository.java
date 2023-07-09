package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	Teacher findByfname(String fn);
	
	Teacher findByEmailAndPassword(String email, String password);
}
