package com.riwi.Multimedia.content.management.api.dto.request;

import com.riwi.Multimedia.content.management.domain.entities.Lesson;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "VIDEO|AUDIO|DOCUMENT", message = "The state must be VIDEO, AUDIO or DOCUMENT")
    private String type;

    @NotBlank(message = "URL is required")
    @Size(max = 255, message = "Exceeded the maximum number of characters (255)")
    private String url;

    @NotBlank(message = "The created date is required")
    @FutureOrPresent(message = "It is not possible to enter a date later than the current date.")
    private LocalDateTime created_at;

    @NotBlank(message = "The status is required")
    private Boolean active;

    @NotBlank(message = "Lesson id is required")
    private Long lesson_id;


}
