package com.riwi.Multimedia.content.management.api.dto.request;


import com.riwi.Multimedia.content.management.domain.entities.Lesson;
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
public class ClssReq {

    private Long id;

    private  String name;

    private String description;

    private LocalDateTime created_at;

    private Boolean active;

    private List<Student> students;

    private List<Lesson> lessons;
}
