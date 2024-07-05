package com.practice.project_enrolment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int enrollmentID;
  private int grade;

  @ManyToOne
  @JoinColumn(name = "studentID")
  private Student student;

  @ManyToOne
  @JoinColumn(name="courseID")
  private Course course;


  public Enrollment(Student student, Course course) {
    this.student = student;
    this.course = course;
  }

  public int getEnrollmentID() {
    return enrollmentID;
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
