package com.practice.project_enrolment.mapper;

import com.practice.project_enrolment.entity.CourseEntity;
import com.practice.project_enrolment.entity.EnrolmentEntity;
import com.practice.project_enrolment.entity.StudentEntity;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.Enrolment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnrolmentMapperTest {

  private final EnrolmentMapper enrolmentMapper = Mappers.getMapper(EnrolmentMapper.class);

  @Test
  void testApiToEntity() {
    Enrolment enrolment = new Enrolment();
    enrolment.setCourseId(1);
    enrolment.setStudentId(1);
    enrolment.setGrade(85);

    EnrolmentEntity enrolmentEntity = enrolmentMapper.apiToEntity(enrolment);

    assertNotNull(enrolmentEntity);
    assertEquals(1, enrolmentEntity.getCourseEntity().getCourseId());
    assertEquals(1, enrolmentEntity.getStudentEntity().getStudentId());
    assertEquals(85, enrolmentEntity.getGrade());
  }

  @Test
  void testEntityToApi() {
    CourseEntity courseEntity = new CourseEntity();
    courseEntity.setCourseId(1);
    courseEntity.setTitle("Math 101");
    courseEntity.setCredits(3);

    StudentEntity studentEntity = new StudentEntity();
    studentEntity.setStudentId(1);
    studentEntity.setFirstMidName("John");
    studentEntity.setLastName("Doe");
    studentEntity.setEnrolmentDate(LocalDate.now());

    EnrolmentEntity enrolmentEntity = new EnrolmentEntity();
    enrolmentEntity.setCourseEntity(courseEntity);
    enrolmentEntity.setStudentEntity(studentEntity);
    enrolmentEntity.setGrade(90);

    Enrolment enrolment = enrolmentMapper.entityToApi(enrolmentEntity);

    assertNotNull(enrolment);
    assertEquals(1, enrolment.getCourseId());
    assertEquals(1, enrolment.getStudentId());
    assertEquals(90, enrolment.getGrade());
  }
}
