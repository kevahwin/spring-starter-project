package com.practice.project_enrolment.service;

import com.practice.project_enrolment.entity.EnrolmentEntity;
import com.practice.project_enrolment.repository.EnrolmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrolmentService {

  @Autowired
  private EnrolmentRepository enrolmentRepository;

  public List<EnrolmentEntity> getAllEnrollments(){
    return enrolmentRepository.findAll();
  }

  public EnrolmentEntity getEnrollmentId(int id){
    return enrolmentRepository.findById(id).orElse(null);
  }

  public EnrolmentEntity saveEnrollment(EnrolmentEntity enrolmentEntity){
    return enrolmentRepository.save(enrolmentEntity);
  }

  public void deleteEnrollmentById(int id){
    enrolmentRepository.deleteById(id);
  }
}
