package com.riwi.Multimedia.content.management.infrastructure.mappers;

import com.riwi.Multimedia.content.management.api.dto.request.MultimediaReq;
import com.riwi.Multimedia.content.management.api.dto.response.MultimediaResp;
import com.riwi.Multimedia.content.management.domain.entities.Multimedia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface MultimediaMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "created_at", ignore = true),
            @Mapping(target = "lesson_id.id", source = "lesson_id")
    })

    Multimedia toMultimedia(MultimediaReq multimediaReq);

    MultimediaResp toMultimediaResp(Multimedia multimedia);


    @Mapping(target = "lesson_id.id", source = "lesson_id")
    void updateFromMultimediaRequest(MultimediaReq multimediaReq, @MappingTarget Multimedia multimedia);
}
