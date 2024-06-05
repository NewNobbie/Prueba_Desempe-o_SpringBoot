package com.riwi.Multimedia.content.management.api.dto.response;


import com.riwi.Multimedia.content.management.domain.entities.Clss;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResp {

    private Long id;

    private String name;

    private String email;

    private LocalDateTime created_at;

    private Boolean active;

    private Clss class_id;
}
