package com.riwi.Multimedia.content.management.infrastructure.abstrac_services;

import com.riwi.Multimedia.content.management.api.dto.request.LessonReq;
import com.riwi.Multimedia.content.management.api.dto.response.LessonResp;
import org.springframework.data.domain.Page;

public interface ILessonService extends CGService<LessonReq, LessonResp, Long>, UpdateService<LessonReq, LessonResp, Long>{

    public LessonResp disable(Long id);

    public Page<LessonResp> getAll(int page, int size, String name);
}
