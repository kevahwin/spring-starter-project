package com.practice.project_enrolment.repository;

import com.practice.project_enrolment.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

}
