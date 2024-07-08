package com.practice.project_enrolment.repository;

import com.practice.project_enrolment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}


