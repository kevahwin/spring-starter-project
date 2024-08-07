package com.practice.project_enrolment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int courseId;
  private String title;
  private int credits;

  @OneToMany(mappedBy = "courseEntity")
  private List<EnrolmentEntity> enrolmentEntities;

  public CourseEntity(String title, int credits) {
    this.title = title;
    this.credits = credits;
  }
}
