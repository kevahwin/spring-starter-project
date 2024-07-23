package com.practice.project_enrolment.controller;

import com.practice.project_enrolment.entity.StudentEntity;
import com.practice.project_enrolment.mapper.StudentMapper;
import com.practice.project_enrolment.service.StudentService;
import java.util.List;
import org.openapitools.api.StudentsApi;
import org.openapitools.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController implements StudentsApi {

  @Autowired
  private StudentService studentService;

  @Autowired
  private StudentMapper studentMapper;

  @Override
  public ResponseEntity<Void> createStudent(Student student) {
    StudentEntity studentEntity = studentMapper.apiToEntity(student);
    studentService.saveStudent(studentEntity);
    return ResponseEntity.status(201).build();
  }

  @Override
  public ResponseEntity<Void> deleteStudent(Integer id) {
    studentService.deleteStudentById(id);
    return ResponseEntity.status(204).build();
  }

  @Override
  public ResponseEntity<List<Student>> getAllStudents() {
    List<StudentEntity> studentEntityList = studentService.getAllStudents();
    List<Student> students = studentEntityList.stream()
        .map(studentMapper::entityToApi)
        .toList();
    return ResponseEntity.ok(students);
  }

  @Override
  public ResponseEntity<Student> getStudentById(Integer id) {
    return studentService.getStudentById(id)
        .map(studentMapper::entityToApi)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.status(400).build());
  }

  @Override
  public ResponseEntity<Void> updateStudent(Integer id, Student student) {
    StudentEntity studentEntity = studentMapper.apiToEntity(student);
    studentService.updateStudent(id, studentEntity);
    return ResponseEntity.status(200).build();
  }
}
