package com.practice.project_enrolment.service;

import com.practice.project_enrolment.entity.Enrolment;
import com.practice.project_enrolment.repository.EnrolmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrolmentService {

  @Autowired
  private EnrolmentRepository enrolmentRepository;

  public List<Enrolment> getAllEnrollments(){
    return enrolmentRepository.findAll();
  }

  public Enrolment getEnrollmentId(int id){
    return enrolmentRepository.findById(id).orElse(null);
  }

  public Enrolment saveEnrollment(Enrolment enrolment){
    return enrolmentRepository.save(enrolment);
  }

  public void deleteEnrollmentById(int id){
    enrolmentRepository.deleteById(id);
  }
}
