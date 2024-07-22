package com.practice.project_enrolment.repository;

import com.practice.project_enrolment.entity.EnrolmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolmentRepository extends JpaRepository<EnrolmentEntity, Integer> {

}
