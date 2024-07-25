package com.practice.project_enrolment.service;

import com.practice.project_enrolment.entity.EnrolmentEntity;
import com.practice.project_enrolment.repository.EnrolmentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrolmentService {

  @Autowired
  private EnrolmentRepository enrolmentRepository;

  public List<EnrolmentEntity> getAllEnrollments(){
    return enrolmentRepository.findAll();
  }

  public Optional<EnrolmentEntity> getEnrollmentId(int id){
    return enrolmentRepository.findById(id);
  }

  public EnrolmentEntity saveEnrollment(EnrolmentEntity enrolmentEntity){
    return enrolmentRepository.save(enrolmentEntity);
  }

  public void deleteEnrollmentById(int id){
    enrolmentRepository.deleteById(id);
  }

  public EnrolmentEntity updateEnrolment(int id, EnrolmentEntity enrolmentEntity){
    return enrolmentRepository.findById(id).map(
        existingCourse -> {
          existingCourse.setGrade(enrolmentEntity.getGrade());
          existingCourse.setCourseEntity(enrolmentEntity.getCourseEntity());
          existingCourse.setStudentEntity(enrolmentEntity.getStudentEntity());
          return enrolmentRepository.save(existingCourse);
        }
    ).orElseThrow(() -> new RuntimeException("Enrolment not found"));
  }
}
