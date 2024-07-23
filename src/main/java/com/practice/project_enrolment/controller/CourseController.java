package com.practice.project_enrolment.controller;

import com.practice.project_enrolment.entity.CourseEntity;
import com.practice.project_enrolment.service.CourseService;
import com.practice.project_enrolment.mapper.CourseMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.openapitools.api.CoursesApi;
import org.openapitools.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController implements CoursesApi{

  @Autowired
  private CourseService courseService;
  @Autowired
  private CourseMapper courseMapper;

  @Override
  public ResponseEntity<Void> createCourse(Course course) {
    CourseEntity courseEntity = courseMapper.apiToEntity(course);
    courseService.saveCourse(courseEntity);
    return ResponseEntity.status(201).build(); //Created
  }

  @Override
  public ResponseEntity<Void> deleteCourse(Integer id) {
    courseService.deleteCourse(id);
    return ResponseEntity.status(204).build(); //No content
  }

  @Override
  public ResponseEntity<List<Course>> getAllCourses() {
    List<CourseEntity> entities = courseService.findAll();
    List<Course> courses = entities.stream()
        .map(courseMapper::entityToApi)
        .toList();
    return ResponseEntity.ok(courses); //Success
  }

  @Override
  public ResponseEntity<Course> getCourseById(Integer id) {
    return courseService.getCourseById(id)
        .map(courseMapper::entityToApi)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.status(404).build()); //Not found if course is absent
  }

  @Override
  public ResponseEntity<Void> updateCourse(Integer id, Course course) {
    CourseEntity entity = courseMapper.apiToEntity(course);
    courseService.updateCourse(id, entity);
    return ResponseEntity.status(200).build(); //Success
  }


}
