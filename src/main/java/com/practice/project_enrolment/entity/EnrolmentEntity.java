package com.practice.project_enrolment.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
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

}
