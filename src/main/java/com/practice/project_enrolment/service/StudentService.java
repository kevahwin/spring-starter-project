package com.practice.project_enrolment.service;

import com.practice.project_enrolment.entity.Student;
import com.practice.project_enrolment.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<Student> getAllStudents(){
    return studentRepository.findAll();
  }

  public Student getStudentById(int id){
    return studentRepository.findById(id).orElse(null);
  }

  public Student saveStudent(Student student){
    return studentRepository.save(student);
  }

  public void deleteStudentById(int id){
    studentRepository.deleteById(id);
  }



}
