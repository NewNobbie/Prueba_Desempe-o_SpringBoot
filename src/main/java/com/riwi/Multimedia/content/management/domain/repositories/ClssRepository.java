package com.riwi.Multimedia.content.management.domain.repositories;

import com.riwi.Multimedia.content.management.domain.entities.Clss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClssRepository extends JpaRepository<Clss, Long> {
}
