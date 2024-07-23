package com.practice.project_enrolment.mapper;

import com.practice.project_enrolment.entity.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.openapitools.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
  StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

  @Mapping(target = "studentId", source = "studentId")
  @Mapping(target = "lastName", source = "lastName")
  @Mapping(target = "firstMidName", source="firstMidName")
  @Mapping(target = "enrolmentDate", source="enrollmentDate")
  StudentEntity apiToEntity(Student student);

  @Mapping(target = "studentId", source = "studentId")
  @Mapping(target = "lastName", source = "lastName")
  @Mapping(target = "firstMidName", source="firstMidName")
  @Mapping(target = "enrollmentDate", source="enrolmentDate")
  Student entityToApi(StudentEntity studentEntity);




}
