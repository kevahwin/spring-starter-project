package com.practice.project_enrolment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Student {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int studentId;
  private String lastName;
  private String firstMidName;

  private Date enrollmentDate;

  @OneToMany(mappedBy = "student")
  private List<Enrollment> enrollments;

  public Student(String lastName, String firstMidName, Date enrollmentDate) {
    this.lastName = lastName;
    this.firstMidName = firstMidName;
    this.enrollmentDate = enrollmentDate;
  }

  public int getStudentId() {
    return studentId;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstMidName() {
    return firstMidName;
  }

  public void setFirstMidName(String firstMidName) {
    this.firstMidName = firstMidName;
  }

  public Date getEnrollmentDate() {
    return enrollmentDate;
  }
}
