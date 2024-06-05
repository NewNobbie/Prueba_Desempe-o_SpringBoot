package com.riwi.Multimedia.content.management.infrastructure.services;

import com.riwi.Multimedia.content.management.api.dto.request.ClssReq;
import com.riwi.Multimedia.content.management.api.dto.response.ClssResp;
import com.riwi.Multimedia.content.management.api.dto.response.StudentResp;
import com.riwi.Multimedia.content.management.domain.entities.Clss;
import com.riwi.Multimedia.content.management.domain.entities.Student;
import com.riwi.Multimedia.content.management.domain.repositories.ClssRepository;
import com.riwi.Multimedia.content.management.infrastructure.abstrac_services.IClssService;
import com.riwi.Multimedia.content.management.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClssService implements IClssService {

    @Autowired
    private final ClssRepository clssRepository;

    @Override
    public ClssResp create(ClssReq request) {
        Clss clss = this.requestEntity(request, new Clss());

        clss.setActive(true);
        clss.setCreated_ad(LocalDateTime.now());
        return this.entityResponse(this.clssRepository.save(clss), 0);
    }

    @Override
    public Page<ClssResp> getAll(Pageable pageable) {
        Page<Clss> clssPage = clssRepository.findAll(pageable);
        return clssPage.map(clss-> this.entityResponse(clss));
    }

    @Override
    public ClssResp get(Long aLong) {
        return null;
    }


    public Clss find(Long id){
        return this.clssRepository.findById(id).orElseThrow(()-> new IdNotFoundException("Classes"));
    }

    private StudentResp entityToResponseStudent(Student entity){
        StudentResp response = new StudentResp();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    private ClssResp entityResponse(Clss entity, int valid){
        ClssResp response = new ClssResp();
        BeanUtils.copyProperties(entity,response);

        List<StudentResp> student = new ArrayList<>();
        if (valid==1){
            if (entity.getStudents()!=null) {
                student = entity.getStudents().stream().map(this::entityToResponseStudent).collect(Collectors.toList());
            }
        }
        response.setStudents(student);
        return response;
    }

    public Clss requestEntity (ClssReq request, Clss clss){
        BeanUtils.copyProperties(request,clss);
        return clss;
    }
}
