package com.riwi.Multimedia.content.management.infrastructure.mappers;

import com.riwi.Multimedia.content.management.api.dto.request.ClssReq;
import com.riwi.Multimedia.content.management.api.dto.response.ClssResp;
import com.riwi.Multimedia.content.management.domain.entities.Clss;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ClssMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "created_at", ignore = true)

    })

    Clss toClss(ClssReq clssReq);

    ClssResp toClssResp(Clss clss);

    void updateFromClssRequest(ClssReq clssReq, @MappingTarget Clss clss);
}
