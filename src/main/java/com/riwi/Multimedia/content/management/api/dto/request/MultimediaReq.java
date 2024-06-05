package com.riwi.Multimedia.content.management.api.dto.request;

import com.riwi.Multimedia.content.management.domain.entities.Clss;
import com.riwi.Multimedia.content.management.domain.entities.Lesson;
import com.riwi.Multimedia.content.management.util.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "The type is required")
    private Type type;

    @NotBlank(message = "URL is required")
    @Size(max = 255, message = "Exceeded the maximum number of characters (255)")
    private String url;

    @NotBlank(message = "The created date is required")
    private LocalDateTime created_at;

    @NotBlank(message = "The status is required")
    private Boolean active;

    @NotBlank(message = "Lesson id is required")
    private Lesson lesson_id;


}
