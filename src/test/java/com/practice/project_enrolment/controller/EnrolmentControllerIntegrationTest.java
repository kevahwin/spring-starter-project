package com.practice.project_enrolment.controller;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.openapitools.model.Enrolment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles({"test"})
@SpringBootTest
@AutoConfigureMockMvc
public class EnrolmentControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private EnrolmentRepository enrolmentRepository;
  @Autowired
  private StudentRepository studentRepository;
  @Autowired
  private CourseRepository courseRepository;

  private StudentEntity studentEntity;
  private CourseEntity courseEntity;

  @BeforeEach
  void setUp() {
    enrolmentRepository.deleteAll();
    studentRepository.deleteAll();
    courseRepository.deleteAll();

    studentEntity = new StudentEntity();
    studentEntity.setFirstMidName("Joe");
    studentEntity.setLastName("Fraser");
    studentEntity.setEnrolmentDate(LocalDate.of(1993, 7, 31));
    studentEntity = studentRepository.save(studentEntity);

    courseEntity = new CourseEntity();
    courseEntity.setTitle("Physics 103");
    courseEntity.setCredits(4);
    courseEntity = courseRepository.save(courseEntity);
  }

  @Test
  void testCreateEnrolment() throws Exception {
    Enrolment enrolment = new Enrolment();
    enrolment.setStudentId(studentEntity.getStudentId());
    enrolment.setCourseId(courseEntity.getCourseId());
    enrolment.setGrade(85);

    mockMvc.perform(post("/enrolments")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(enrolment)))
        .andExpect(status().isCreated());
  }

  @Test
  void testGetAllEnrolments() throws Exception {
    EnrolmentEntity enrolmentEntity = new EnrolmentEntity();
    enrolmentEntity.setStudentEntity(studentEntity);
    enrolmentEntity.setCourseEntity(courseEntity);
    enrolmentEntity.setGrade(90);
    enrolmentRepository.save(enrolmentEntity);

    mockMvc.perform(get("/enrolments"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].studentId").value(studentEntity.getStudentId()))
        .andExpect(jsonPath("$[0].courseId").value(courseEntity.getCourseId()))
        .andExpect(jsonPath("$[0].grade").value(90));
  }

  @Test
  void testGetEnrolmentById() throws Exception {
    EnrolmentEntity enrolmentEntity = new EnrolmentEntity();
    enrolmentEntity.setStudentEntity(studentEntity);
    enrolmentEntity.setCourseEntity(courseEntity);
    enrolmentEntity.setGrade(65);
    EnrolmentEntity savedEnrolment = enrolmentRepository.save(enrolmentEntity);

    mockMvc.perform(get("/enrolments/" + savedEnrolment.getEnrolmentId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.studentId").value(studentEntity.getStudentId()))
        .andExpect(jsonPath("$.courseId").value(courseEntity.getCourseId()))
        .andExpect(jsonPath("$.grade").value(65));
  }

  @Test
  void testDeleteEnrolment() throws Exception {
    EnrolmentEntity enrolmentEntity = new EnrolmentEntity();
    enrolmentEntity.setStudentEntity(studentEntity);
    enrolmentEntity.setCourseEntity(courseEntity);
    enrolmentEntity.setGrade(85);
    EnrolmentEntity savedEnrolment = enrolmentRepository.save(enrolmentEntity);

    mockMvc.perform(delete("/enrolments/" + savedEnrolment.getEnrolmentId()))
        .andExpect(status().isNoContent());

    assertFalse(enrolmentRepository.existsById(savedEnrolment.getEnrolmentId()));
  }

  @Test
  void testUpdateEnrolment() throws Exception {
    EnrolmentEntity enrolmentEntity = new EnrolmentEntity();
    enrolmentEntity.setStudentEntity(studentEntity);
    enrolmentEntity.setCourseEntity(courseEntity);
    enrolmentEntity.setGrade(85);
    enrolmentEntity = enrolmentRepository.save(enrolmentEntity);

    Enrolment updatedEnrolment = new Enrolment();
    updatedEnrolment.setStudentId(studentEntity.getStudentId());
    updatedEnrolment.setCourseId(courseEntity.getCourseId());
    updatedEnrolment.setGrade(90);

    mockMvc.perform(put("/poenrolments/" + enrolmentEntity.getEnrolmentId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(updatedEnrolment)))
        .andExpect(status().isOk());

    Optional<EnrolmentEntity> updatedEntity = enrolmentRepository.findById(enrolmentEntity.getEnrolmentId());
    assertTrue(updatedEntity.isPresent());
    assertEquals(90, updatedEntity.get().getGrade());
  }

}
