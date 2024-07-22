package com.practice.project_enrolment.mapper;
import com.practice.project_enrolment.entity.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface CourseMapper {
  CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

  @Mapping(target = "courseId", source = "courseId")
  @Mapping(target = "title", source = "title")
  @Mapping(target = "credits", source = "credits")
  CourseEntity apiToEntity(org.openapitools.model.Course course);

  @Mapping(target = "courseId", source = "courseId")
  @Mapping(target = "title", source = "title")
  @Mapping(target = "credits", source = "credits")
  org.openapitools.model.Course entityToApi(CourseEntity courseEntity);
}


