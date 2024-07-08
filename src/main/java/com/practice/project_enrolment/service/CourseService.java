package com.practice.project_enrolment.service;

import com.practice.project_enrolment.entity.Course;
import com.practice.project_enrolment.repository.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  public List<Course> getAllCourses(){
    return courseRepository.findAll();
  }

  public Course getCourseById(int id){
    return courseRepository.findById(id).orElse(null);
  }

  public Course saveCourse(Course course){
    return courseRepository.save(course);
  }

  public void deleteCourse(int id){
    courseRepository.deleteById(id);
  }
}
