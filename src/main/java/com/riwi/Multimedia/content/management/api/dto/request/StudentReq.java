package com.riwi.Multimedia.content.management.api.dto.request;


import com.riwi.Multimedia.content.management.domain.entities.Clss;
import jakarta.validation.constraints.Email;
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
public class StudentReq {

    @NotBlank(message = "The name is required")
    @Size(max = 255, message = "Exceeded the maximum number of characters (255)")
    private String name;


    @Email(message = "Must be a email")
    @NotBlank(message = "The name is required")
    @Size(max = 255, message = "Exceeded the maximum number of characters (255)")
    private String email;

    @NotBlank(message = "Class id is required")
    private Long class_id;

}
