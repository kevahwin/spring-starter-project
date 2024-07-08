package com.practice.project_enrolment.repository;

import com.practice.project_enrolment.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
