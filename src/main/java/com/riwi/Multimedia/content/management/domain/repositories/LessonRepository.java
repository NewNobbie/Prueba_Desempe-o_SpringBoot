package com.riwi.Multimedia.content.management.domain.repositories;

import com.riwi.Multimedia.content.management.domain.entities.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    public Page<Lesson> findAllByActive(Boolean active, PageRequest pageRequest);
}
