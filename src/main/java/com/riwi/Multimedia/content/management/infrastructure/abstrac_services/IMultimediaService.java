package com.riwi.Multimedia.content.management.infrastructure.abstrac_services;

import com.riwi.Multimedia.content.management.api.dto.request.MultimediaReq;
import com.riwi.Multimedia.content.management.api.dto.response.MultimediaResp;

public interface IMultimediaService extends CGService<MultimediaReq, MultimediaResp, Long>, UpdateService<MultimediaReq, MultimediaResp, Long>{

}
