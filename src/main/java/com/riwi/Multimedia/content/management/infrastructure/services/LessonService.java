package com.riwi.Multimedia.content.management.infrastructure.services;


import com.riwi.Multimedia.content.management.api.dto.request.LessonReq;
import com.riwi.Multimedia.content.management.api.dto.request.MultimediaReq;
import com.riwi.Multimedia.content.management.api.dto.response.LessonResp;
import com.riwi.Multimedia.content.management.api.dto.response.MultimediaResp;
import com.riwi.Multimedia.content.management.domain.entities.Lesson;
import com.riwi.Multimedia.content.management.domain.entities.Multimedia;
import com.riwi.Multimedia.content.management.domain.repositories.LessonRepository;
import com.riwi.Multimedia.content.management.domain.repositories.MultimediaRepository;
import com.riwi.Multimedia.content.management.infrastructure.abstrac_services.ILessonService;
import com.riwi.Multimedia.content.management.util.exeptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {

    @Autowired
    private final LessonRepository lessonRepository;

    @Autowired
    private final MultimediaRepository multimediaRepository;


    @Override
    public LessonResp create(LessonReq request) {
        Lesson lesson = this.requestEntity(request, new Lesson());

        lesson.setCreate_at(LocalDateTime.now());
        lesson.setActive(true);
        Lesson response = this.lessonRepository.save(lesson);
        request.getMultimediaList().forEach(multi -> this.createMultimedia(multi, response.getId()));

        return this.entityToResponse(this.find(response.getId()));
    }

    private void createMultimedia(MultimediaReq multimedia, Long id){
        Lesson lesson = this.find(id);
        Multimedia multimedia2 = new Multimedia();

        BeanUtils.copyProperties(multimedia, multimedia2);
        multimedia2.setLesson_id(lesson);
        multimedia2.setCreated_at(LocalDateTime.now());
        multimedia2.setActive(true);
        this.multimediaRepository.save(multimedia2);
    }

    @Override
    public Page<LessonResp> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public LessonResp get(Long aLong) {
        return this.entityToResponse(this.find(aLong));
    }

    @Override
    public LessonResp update(Long aLong, LessonReq request) {
        return null;
    }

    @Override
    public Page<LessonResp> getAll(int page, int size, String name) {
        if (page<0)
            page=0;

        PageRequest pagination = PageRequest.of(page, size);
        return this.lessonRepository.findAllByActive(true, pagination).map(this::entityToResponse);
    }

    public Lesson find(Long id){
        return this.lessonRepository.findById(id).orElseThrow(()-> new IdNotFoundException("Lesion"));
    }

    private LessonResp entityToResponse(Lesson entity){

        LessonResp response = new LessonResp();
        BeanUtils.copyProperties(entity,response);
        List<MultimediaResp> multimediaResponses = new ArrayList<>();

        if (entity.getMultimediaList()!=null){
            multimediaResponses = entity.getMultimediaList().stream().map(this::entityResponseMultimedia).collect(Collectors.toList());
        }
        response.setMultimediaList(multimediaResponses);
        return response;
    }

    private MultimediaResp entityResponseMultimedia(Multimedia entity){
        MultimediaResp response = new MultimediaResp();
        BeanUtils.copyProperties(entity, response);
        return response;
    }

    private Lesson requestEntity(LessonReq request, Lesson lesson){

        BeanUtils.copyProperties(request, lesson);

        return lesson;
    }

    @Override
    public LessonResp disable(Long id) {
        Lesson lesson = this.find(id);
        lesson.setActive(false);

        return this.entityToResponse(this.lessonRepository.save(lesson));
    }
}
