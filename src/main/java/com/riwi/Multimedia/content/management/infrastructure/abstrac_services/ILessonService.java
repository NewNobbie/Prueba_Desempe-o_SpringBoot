package com.riwi.Multimedia.content.management.infrastructure.abstrac_services;

import com.riwi.Multimedia.content.management.api.dto.request.LessonReq;
import com.riwi.Multimedia.content.management.api.dto.response.LessonResp;

public interface ILessonService extends CGService<LessonReq, LessonResp, Long>, UpdateService<LessonReq, LessonResp, Long>{

}
