package com.riwi.Multimedia.content.management.api.dto.request;


import com.riwi.Multimedia.content.management.domain.entities.Lesson;
import com.riwi.Multimedia.content.management.domain.entities.Student;
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
public class ClssReq {

    @NotBlank(message = "The name is required")
    @Size(max = 255, message = "Exceeded the maximum number of characters (255)")
    private  String name;

    @NotBlank(message = "The description is required")
    private String description;

    @NotBlank(message = "The created date is required")
    private LocalDateTime created_at;

    @NotBlank(message = "The status is required")
    private Boolean active;

    /*@NotBlank(message = "Students list is required")
    private List<Student> students;

    @NotBlank(message = "Lessons list is required")
    private List<Lesson> lessons;*/
}
