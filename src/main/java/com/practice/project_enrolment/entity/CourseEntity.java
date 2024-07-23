package com.practice.project_enrolment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;


@Entity
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int courseId;
  private String title;


  private int credits;

  @OneToMany(mappedBy = "courseEntity")
  private List<EnrolmentEntity> enrolmentEntities;

  public CourseEntity() {
  }

  public CourseEntity(String title, int credits) {
    this.title = title;
    this.credits = credits;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public int getCourseId() {
    return courseId;
  }

  public String getTitle() {
    return title;
  }

  public int getCredits() {
    return credits;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

}
