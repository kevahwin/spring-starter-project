package com.practice.project_enrolment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import org.springframework.data.annotation.Id;

@Entity
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int courseID;
  private String title;
  private int credits;

  @OneToMany(mappedBy = "courseID")
  private List<Enrollment> enrollments;

  public Course(String title, int credits) {
    this.title = title;
    this.credits = credits;
  }

  public int getCourseID() {
    return courseID;
  }

  public String getTitle() {
    return title;
  }


  public int getCredits() {
    return credits;
  }

}
