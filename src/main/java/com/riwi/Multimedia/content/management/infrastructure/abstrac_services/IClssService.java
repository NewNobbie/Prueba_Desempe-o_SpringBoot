package com.riwi.Multimedia.content.management.infrastructure.abstrac_services;

import com.riwi.Multimedia.content.management.api.dto.request.ClssReq;
import com.riwi.Multimedia.content.management.api.dto.response.ClssResp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IClssService extends CGService<ClssReq, ClssResp, Long>{

    public Page<ClssResp> getAllActive(String name, String description, int page, int size);
}
