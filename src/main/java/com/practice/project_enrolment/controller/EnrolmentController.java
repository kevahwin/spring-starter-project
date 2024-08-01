package com.practice.project_enrolment.controller;

import com.practice.project_enrolment.entity.CourseEntity;
import com.practice.project_enrolment.entity.EnrolmentEntity;
import com.practice.project_enrolment.entity.StudentEntity;
import com.practice.project_enrolment.mapper.EnrolmentMapper;
import com.practice.project_enrolment.service.CourseService;
import com.practice.project_enrolment.service.EnrolmentService;
import com.practice.project_enrolment.service.StudentService;
import java.util.List;
import java.util.Optional;
import org.openapitools.api.EnrolmentsApi;
import org.openapitools.model.Enrolment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrolmentController implements EnrolmentsApi {
  @Autowired private EnrolmentService enrolmentService;

  @Autowired private StudentService studentService;

  @Autowired private CourseService courseService;
  @Autowired private EnrolmentMapper enrolmentMapper;

  @Override
  public ResponseEntity<Void> createEnrolment(Enrolment enrolment) {
    Optional<StudentEntity> studentEntity = studentService.getStudentById(enrolment.getStudentId());
    Optional<CourseEntity> courseEntity = courseService.getCourseById(enrolment.getCourseId());

    if (!studentEntity.isPresent() || !courseEntity.isPresent()) {
      return ResponseEntity.status(404).build();
    }

    EnrolmentEntity entity = enrolmentMapper.apiToEntity(enrolment);
    entity.setCourseEntity(courseEntity.get());
    entity.setStudentEntity(studentEntity.get());
    enrolmentService.saveEnrolment(entity);
    return ResponseEntity.status(201).build();
  }

  @Override
  public ResponseEntity<Void> deleteEnrolment(Integer id) {
    enrolmentService.deleteEnrolmentById(id);
    return ResponseEntity.status(204).build();
  }

  @Override
  public ResponseEntity<List<Enrolment>> getAllEnrolments() {
    List<EnrolmentEntity> entities = enrolmentService.getAllEnrolments();
    List<Enrolment> enrolments = entities.stream().map(enrolmentMapper::entityToApi).toList();
    return ResponseEntity.ok(enrolments);
  }

  @Override
  public ResponseEntity<Enrolment> getEnrolmentById(Integer id) {
    return enrolmentService
        .getEnrolmentId(id)
        .map(enrolmentMapper::entityToApi)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.status(404).build());
  }

  @Override
  public ResponseEntity<Void> updateEnrolment(Integer id, Enrolment enrolment) {
    Optional<StudentEntity> studentEntity = studentService.getStudentById(enrolment.getStudentId());
    Optional<CourseEntity> courseEntity = courseService.getCourseById(enrolment.getStudentId());
    EnrolmentEntity enrolmentEntity = enrolmentMapper.apiToEntity(enrolment);
    enrolmentService.updateEnrolment(id, enrolmentEntity);
    return ResponseEntity.status(200).build();
  }
}
