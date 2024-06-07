package com.riwi.Multimedia.content.management.domain.entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "clss")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class   Clss {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(20)")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private Boolean active;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "class_id",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<Student> students;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "class_id",
            cascade = CascadeType.ALL,
            orphanRemoval = false
    )
    private List<Lesson> lessons;



}
