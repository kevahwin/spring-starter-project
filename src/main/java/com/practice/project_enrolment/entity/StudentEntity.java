package com.practice.project_enrolment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentEntity {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int studentId;
  private String lastName;
  private String firstMidName;

  private LocalDate enrolmentDate;

  @OneToMany(mappedBy = "studentEntity")
  private List<EnrolmentEntity> enrolmentEntities;

  public StudentEntity(String lastName, String firstMidName,
      LocalDate enrolmentDate) {
    this.lastName = lastName;
    this.firstMidName = firstMidName;
    this.enrolmentDate = enrolmentDate;
  }
}
