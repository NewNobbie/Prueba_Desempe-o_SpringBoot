package com.riwi.Multimedia.content.management.infrastructure.mappers;

import com.riwi.Multimedia.content.management.api.dto.request.MultimediaReq;
import com.riwi.Multimedia.content.management.api.dto.response.MultimediaResp;
import com.riwi.Multimedia.content.management.domain.entities.Multimedia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MultimediaMapper {
    @Mapping(target = "id", ignore = true)
    Multimedia toMultimedia(MultimediaReq multimediaReq);

    MultimediaResp toMultimediaResp(Multimedia multimedia);

    void updateFromMultimediaRequest(MultimediaReq multimediaReq, @MappingTarget Multimedia multimedia);
}
