package com.practice.project_enrolment.repository;

import com.practice.project_enrolment.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{

}


