package com.app.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
