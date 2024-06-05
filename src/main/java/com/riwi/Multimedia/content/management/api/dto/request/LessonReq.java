package com.riwi.Multimedia.content.management.api.dto.request;

import com.riwi.Multimedia.content.management.domain.entities.Clss;
import com.riwi.Multimedia.content.management.domain.entities.Lesson;
import com.riwi.Multimedia.content.management.domain.entities.Multimedia;
import com.riwi.Multimedia.content.management.domain.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonReq {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime created_at;

    private Boolean active;

    private Clss class_id;

    private List<Multimedia> multimediaList;
}
