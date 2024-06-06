package com.riwi.Multimedia.content.management.infrastructure.mappers;

import com.riwi.Multimedia.content.management.api.dto.request.ClssReq;
import com.riwi.Multimedia.content.management.api.dto.response.ClssResp;
import com.riwi.Multimedia.content.management.domain.entities.Clss;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClssMapper {
    @Mapping(target = "id", ignore = true)
    Clss toClss(ClssReq clssReq);

    ClssResp toClssResp(Clss clss);

    void updateFromClssRequest(ClssReq clssReq, @MappingTarget Clss clss);
}
