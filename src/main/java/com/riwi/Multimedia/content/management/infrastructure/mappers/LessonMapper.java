package com.riwi.Multimedia.content.management.infrastructure.mappers;

import com.riwi.Multimedia.content.management.api.dto.request.LessonReq;
import com.riwi.Multimedia.content.management.api.dto.response.LessonResp;
import com.riwi.Multimedia.content.management.domain.entities.Lesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LessonMapper {
    @Mapping(target = "id", ignore = true)
    Lesson toLesson(LessonReq lessonReq);

    LessonResp toLessonResp(Lesson lesson);

    void updateFromLessonRequest(LessonReq lessonReq, @MappingTarget Lesson lesson);
}
