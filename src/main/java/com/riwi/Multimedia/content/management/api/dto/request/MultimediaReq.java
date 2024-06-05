package com.riwi.Multimedia.content.management.api.dto.request;

import com.riwi.Multimedia.content.management.domain.entities.Clss;
import com.riwi.Multimedia.content.management.domain.entities.Lesson;
import com.riwi.Multimedia.content.management.util.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaReq {

    private Long id;

    private Type type;

    private String url;

    private LocalDateTime created_at;

    private Boolean active;

    private Lesson lesson_id;
}
