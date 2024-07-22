package com.practice.project_enrolment.service;

import com.practice.project_enrolment.entity.CourseEntity;
import java.util.Optional;
import com.practice.project_enrolment.repository.CourseRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  public List<CourseEntity> findAll(){
    return courseRepository.findAll();
  }

  public Optional<CourseEntity> getCourseById(int id){
    return courseRepository.findById(id);
  }

  public CourseEntity saveCourse(CourseEntity courseEntity){
    return courseRepository.save(courseEntity);
  }

  public void deleteCourse(int id){
    courseRepository.deleteById(id);
  }

  public CourseEntity updateCourse(int id, CourseEntity courseEntity){
    return courseRepository.findById(id).map(
        existingCourse -> {
          existingCourse.setTitle(courseEntity.getTitle());
          existingCourse.setCredits(courseEntity.getCredits());
          return courseRepository.save(existingCourse);
        }
    ).orElseThrow(() -> new RuntimeException("Course not found"));
  }
}
