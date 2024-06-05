package com.riwi.Multimedia.content.management.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "multimedia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class multimedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT(20)")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Enum type;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String url;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private Boolean active;


}
