package com.practice.project_enrolment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;


@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int courseId;
  private String title;
  private int credits;

  @OneToMany(mappedBy = "course")
  private List<Enrolment> enrolments;

  public Course(String title, int credits) {
    this.title = title;
    this.credits = credits;
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

}
