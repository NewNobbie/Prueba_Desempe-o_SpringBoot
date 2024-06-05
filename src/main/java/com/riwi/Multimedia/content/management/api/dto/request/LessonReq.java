package com.riwi.Multimedia.content.management.api.dto.request;

import com.riwi.Multimedia.content.management.domain.entities.Multimedia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Exceeded the maximum number of characters (255)")
    private String title;

    @NotBlank(message = "The content is required")
    private String content;

    @NotBlank(message = "The created date is required")
    private LocalDateTime created_at;

    @NotBlank(message = "The status is required")
    private Boolean active;

    @NotBlank(message = "Class id is required")
    private Long class_id;

    /*@NotBlank(message = "Multimedia List is required")
    private List<Multimedia> multimediaList;*/
}
