package com.practice.project_enrolment.repository;

import com.practice.project_enrolment.entity.CourseEntity;
import com.practice.project_enrolment.entity.EnrolmentEntity;
import com.practice.project_enrolment.entity.StudentEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles({"test"})
@DataJpaTest
public class EnrolmentRepositoryTest {
  @Autowired
  private EnrolmentRepository enrolmentRepository;
  @Autowired
  private CourseRepository courseRepository;
  @Autowired
  private StudentRepository studentRepository;
  private StudentEntity studentEntity;
  private CourseEntity courseEntity;


  @BeforeEach
  void setUp(){
    studentRepository.deleteAll();
    courseRepository.deleteAll();
    enrolmentRepository.deleteAll();

    studentEntity = new StudentEntity("John Doe", "Pence", LocalDate.now());
    studentRepository.saveAndFlush(studentEntity);
    courseEntity = new CourseEntity("Math 101", 3);
    courseRepository.saveAndFlush(courseEntity);

  }



  @Test
  void testSaveEnrolment(){


    EnrolmentEntity enrolment = new EnrolmentEntity();
    enrolment.setStudentEntity(studentEntity);
    enrolment.setCourseEntity(courseEntity);
    enrolment.setGrade(75);

    EnrolmentEntity savedEnrolment = enrolmentRepository.save(enrolment);

    assertNotNull(savedEnrolment);
    assertEquals(75, savedEnrolment.getGrade());
  }

  @Test
  void testFindById(){


    EnrolmentEntity enrolment = new EnrolmentEntity();
    enrolment.setStudentEntity(studentEntity);
    enrolment.setCourseEntity(courseEntity);
    enrolment.setGrade(67);

    EnrolmentEntity savedEnrolment = enrolmentRepository.save(enrolment);
    Optional<EnrolmentEntity> foundEnrolment = enrolmentRepository.findById(savedEnrolment.getEnrolmentId());

    assertTrue(foundEnrolment.isPresent());
    assertEquals(savedEnrolment.getEnrolmentId(), foundEnrolment.get().getEnrolmentId());
  }

  @Test
  void testFindAll(){


    EnrolmentEntity enrolmentOne = new EnrolmentEntity();
    enrolmentOne.setStudentEntity(studentEntity);
    enrolmentOne.setCourseEntity(courseEntity);
    enrolmentOne.setGrade(92);
    enrolmentRepository.save(enrolmentOne);

    EnrolmentEntity enrolmentTwo = new EnrolmentEntity();
    enrolmentTwo.setStudentEntity(studentEntity);
    enrolmentTwo.setCourseEntity(courseEntity);
    enrolmentTwo.setGrade(77);
    enrolmentRepository.save(enrolmentTwo);

    List<EnrolmentEntity> foundEnrolments = enrolmentRepository.findAll();
    assertEquals(2, foundEnrolments.size());

  }

  @Test
  void testDeleteById(){


    EnrolmentEntity enrolment = new EnrolmentEntity();
    enrolment.setStudentEntity(studentEntity);
    enrolment.setCourseEntity(courseEntity);
    enrolment.setGrade(87);

    EnrolmentEntity savedEnrolment = enrolmentRepository.save(enrolment);

    enrolmentRepository.deleteById(savedEnrolment.getEnrolmentId());
    Optional<EnrolmentEntity> deletedEnrolment = enrolmentRepository.findById(savedEnrolment.getEnrolmentId());

    assertFalse(deletedEnrolment.isPresent());
  }


}
