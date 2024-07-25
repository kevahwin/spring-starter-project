package com.practice.project_enrolment.mapper;


import com.practice.project_enrolment.entity.CourseEntity;
import com.practice.project_enrolment.entity.EnrolmentEntity;
import com.practice.project_enrolment.entity.StudentEntity;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.Enrolment;

@Mapper(componentModel = "spring")
public interface EnrolmentMapper {

  EnrolmentMapper INSTANCE = Mappers.getMapper(EnrolmentMapper.class);

  @Mapping(source="courseId", target="courseEntity.courseId")
  @Mapping(source="studentId", target="studentEntity.studentId")
  EnrolmentEntity apiToEntity(Enrolment enrolment);

  @Mapping(source="courseEntity.courseId", target="courseId")
  @Mapping(source="studentEntity.studentId", target="studentId")
  Enrolment entityToApi(EnrolmentEntity enrolmentEntity);
}
