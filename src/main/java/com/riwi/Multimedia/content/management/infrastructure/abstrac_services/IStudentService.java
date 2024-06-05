package com.riwi.Multimedia.content.management.infrastructure.abstrac_services;

import com.riwi.Multimedia.content.management.api.dto.request.StudentReq;
import com.riwi.Multimedia.content.management.api.dto.response.StudentResp;

public interface IStudentService extends CGService<StudentReq, StudentResp, Long>, UpdateService<StudentReq, StudentResp, Long>{

    public  StudentResp disable(Long id);
}
