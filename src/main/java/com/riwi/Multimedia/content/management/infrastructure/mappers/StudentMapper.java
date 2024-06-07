package com.riwi.Multimedia.content.management.infrastructure.mappers;

import com.riwi.Multimedia.content.management.api.dto.request.StudentReq;
import com.riwi.Multimedia.content.management.api.dto.response.StudentResp;
import com.riwi.Multimedia.content.management.domain.entities.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mappings({
        @Mapping(target = "id", ignore = true),
            @Mapping(target = "created_at", ignore = true),
            @Mapping(target = "class_id.id", source = "class_id")

    })
    Student toStudent(StudentReq studentReq);

    StudentResp toStudentResp(Student student);
    @Mapping(target = "class_id.id", source = "class_id")
    void updateFromStudentRequest(StudentReq studentReq, @MappingTarget Student student);
}
