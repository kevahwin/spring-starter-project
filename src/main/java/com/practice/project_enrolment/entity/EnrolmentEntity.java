package com.practice.project_enrolment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EnrolmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int enrolmentId;
  private int grade;

  @ManyToOne
  @JoinColumn(name = "studentId")
  private StudentEntity studentEntity;

  @ManyToOne
  @JoinColumn(name="courseId")
  private CourseEntity courseEntity;


  public EnrolmentEntity(StudentEntity studentEntity, CourseEntity courseEntity) {
    this.studentEntity = studentEntity;
    this.courseEntity = courseEntity;
  }

  public int getEnrolmentId() {
    return enrolmentId;
  }


  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public StudentEntity getStudent() {
    return studentEntity;
  }

  public CourseEntity getCourse() {
    return courseEntity;
  }

}
