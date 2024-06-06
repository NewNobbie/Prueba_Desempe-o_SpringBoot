package com.riwi.Multimedia.content.management.infrastructure.mappers;

import com.riwi.Multimedia.content.management.api.dto.request.StudentReq;
import com.riwi.Multimedia.content.management.api.dto.response.StudentResp;
import com.riwi.Multimedia.content.management.domain.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "id", ignore = true)
    Student toStudent(StudentReq studentReq);

    StudentResp toStudentResp(Student student);

    void updateFromStudentRequest(StudentReq studentReq, @MappingTarget Student student);
}
