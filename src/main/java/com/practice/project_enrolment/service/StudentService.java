package com.practice.project_enrolment.service;

import com.practice.project_enrolment.entity.StudentEntity;
import com.practice.project_enrolment.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<StudentEntity> getAllStudents(){
    return studentRepository.findAll();
  }

  public Optional<StudentEntity> getStudentById(int id){
    return studentRepository.findById(id);
  }

  public StudentEntity saveStudent(StudentEntity studentEntity){
    return studentRepository.save(studentEntity);
  }

  public void deleteStudentById(int id){
    studentRepository.deleteById(id);
  }

  public StudentEntity updateStudent(int id, StudentEntity studentEntity){
    return studentRepository.findById(id).map(
        existingStudent -> {
          existingStudent.setLastName(studentEntity.getLastName());
          existingStudent.setFirstMidName(studentEntity.getFirstMidName());
          return studentRepository.save(existingStudent);
        }
    ).orElseThrow(() -> new RuntimeException("Student not found"));
  }



}
