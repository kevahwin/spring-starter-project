package com.practice.project_enrolment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int CourseID;
  private String Title;
  private int Credits;

  public Course(int courseID, String title, int credits) {
    CourseID = courseID;
    Title = title;
    Credits = credits;
  }

  public int getCourseID() {
    return CourseID;
  }

  public void setCourseID(int courseID) {
    CourseID = courseID;
  }

  public String getTitle() {
    return Title;
  }

  public void setTitle(String title) {
    Title = title;
  }

  public int getCredits() {
    return Credits;
  }

  public void setCredits(int credits) {
    Credits = credits;
  }
}
