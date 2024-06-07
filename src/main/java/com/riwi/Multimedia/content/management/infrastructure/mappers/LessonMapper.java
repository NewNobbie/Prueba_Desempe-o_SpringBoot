package com.riwi.Multimedia.content.management.infrastructure.mappers;

import com.riwi.Multimedia.content.management.api.dto.request.LessonReq;
import com.riwi.Multimedia.content.management.api.dto.response.LessonResp;
import com.riwi.Multimedia.content.management.domain.entities.Clss;
import com.riwi.Multimedia.content.management.domain.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "create_at", ignore = true),
            @Mapping(target = "class_id.id", source = "class_id")

    })

    Lesson toLesson(LessonReq lessonReq);

    LessonResp toLessonResp(Lesson lesson);

    @Mapping(target = "class_id.id", source = "class_id")
    void updateFromLessonRequest(LessonReq lessonReq, @MappingTarget Lesson lesson);

}
