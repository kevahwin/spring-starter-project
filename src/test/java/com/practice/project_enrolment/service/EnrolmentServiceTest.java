package com.practice.project_enrolment.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.practice.project_enrolment.entity.CourseEntity;
import com.practice.project_enrolment.entity.EnrolmentEntity;
import com.practice.project_enrolment.entity.StudentEntity;
import com.practice.project_enrolment.repository.CourseRepository;
import com.practice.project_enrolment.repository.EnrolmentRepository;
import com.practice.project_enrolment.repository.StudentRepository;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class EnrolmentServiceTest {

  @Mock
  private EnrolmentRepository enrolmentRepository;
  @Mock
  private StudentRepository studentRepository;
  @Mock
  private CourseRepository courseRepository;

  @InjectMocks
  private EnrolmentService enrolmentService;

  private StudentEntity studentEntity;
  private CourseEntity courseEntity;

  @BeforeEach
  void setUp(){
    MockitoAnnotations.openMocks(this);

    studentEntity = new StudentEntity("John Doe", "Pence", LocalDate.now());
    studentEntity.setStudentId(1);

    courseEntity = new CourseEntity("Math 101", 3);
    courseEntity.setCourseId(1);
  }

  @Test
  void testSaveEnrolment() {
    EnrolmentEntity enrolment = new EnrolmentEntity();
    enrolmentService.saveEnrolment(enrolment);
    verify(enrolmentRepository, times(1)).save(enrolment);
  }

  @Test
  void testDeleteEnrollmentById() {
    when(enrolmentRepository.existsById(1)).thenReturn(true);
    boolean result = enrolmentService.deleteEnrolmentById(1);
    assertTrue(result);
    verify(enrolmentRepository, times(1)).deleteById(1);
  }

  @Test
  void testGetAllEnrolments() {
    enrolmentService.getAllEnrolments();
    verify(enrolmentRepository, times(1)).findAll();
  }

  @Test
  void testGetEnrolmentById() {
    EnrolmentEntity enrolment = new EnrolmentEntity();
    when(enrolmentRepository.findById(1)).thenReturn(Optional.of(enrolment));
    Optional<EnrolmentEntity> result = enrolmentService.getEnrolmentId(1);
    assertTrue(result.isPresent());
    assertEquals(enrolment, result.get());
  }

  @Test
  void testUpdateEnrolment_Success() {
    int enrolmentId = 1;
    EnrolmentEntity existingEnrolment = new EnrolmentEntity();
    existingEnrolment.setEnrolmentId(enrolmentId);
    existingEnrolment.setGrade(85);
    existingEnrolment.setCourseEntity(new CourseEntity("History", 3));
    existingEnrolment.setStudentEntity(new StudentEntity("Jane Doe", "Smith", LocalDate.of(2022, 1, 1)));

    EnrolmentEntity updatedEnrolment = new EnrolmentEntity();
    updatedEnrolment.setGrade(95);
    updatedEnrolment.setCourseEntity(new CourseEntity("Math 101", 4));
    updatedEnrolment.setStudentEntity(new StudentEntity("John Doe", "Pence", LocalDate.of(2021, 9, 1)));

    when(enrolmentRepository.findById(enrolmentId)).thenReturn(Optional.of(existingEnrolment));
    when(enrolmentRepository.save(any(EnrolmentEntity.class))).thenReturn(existingEnrolment);

    EnrolmentEntity result = enrolmentService.updateEnrolment(enrolmentId, updatedEnrolment);

    assertNotNull(result);
    assertEquals(updatedEnrolment.getGrade(), result.getGrade());
    assertEquals(updatedEnrolment.getCourseEntity().getTitle(), result.getCourseEntity().getTitle());
    assertEquals(updatedEnrolment.getStudentEntity().getFirstMidName(), result.getStudentEntity().getFirstMidName());

    verify(enrolmentRepository, times(1)).findById(enrolmentId);
    verify(enrolmentRepository, times(1)).save(existingEnrolment);
  }



}
