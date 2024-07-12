package com.practice.project_enrolment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrolment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int enrolmentId;
  private int grade;

  @ManyToOne
  @JoinColumn(name = "studentId")
  private Student student;

  @ManyToOne
  @JoinColumn(name="courseId")
  private Course course;


  public Enrolment(Student student, Course course) {
    this.student = student;
    this.course = course;
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

  public Student getStudent() {
    return student;
  }

  public Course getCourse() {
    return course;
  }

}
