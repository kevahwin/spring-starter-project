package com.practice.project_enrolment.service;

import com.practice.project_enrolment.entity.Enrollment;
import com.practice.project_enrolment.repository.EnrollmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {

  @Autowired
  private EnrollmentRepository enrollmentRepository;

  public List<Enrollment> getAllEnrollments(){
    return enrollmentRepository.findAll();
  }

  public Enrollment getEnrollmentId(int id){
    return enrollmentRepository.findById(id).orElse(null);
  }

  public Enrollment saveEnrollment(Enrollment enrollment){
    return enrollmentRepository.save(enrollment);
  }

  public void deleteEnrollmentById(int id){
    enrollmentRepository.deleteById(id);
  }
}
