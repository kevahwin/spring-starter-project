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
  private int studentID;
  private String lastName;
  private String firstMidName;

  @GeneratedValue(strategy = GenerationType.AUTO)
  private Date enrollmentDate;

  @OneToMany(mappedBy = "studentID")
  private List<Enrollment> enrollments;

  public Student(String lastName, String firstMidName, Date enrollmentDate) {
    this.lastName = lastName;
    this.firstMidName = firstMidName;
    this.enrollmentDate = enrollmentDate;
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
}
