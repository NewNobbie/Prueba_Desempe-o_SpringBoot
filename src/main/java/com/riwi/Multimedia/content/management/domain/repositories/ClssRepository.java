package com.riwi.Multimedia.content.management.domain.repositories;

import com.riwi.Multimedia.content.management.domain.entities.Clss;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClssRepository extends JpaRepository<Clss, Long> {

    public Page<Clss> findByDescriptionContainingOrNameContainingAndActive(String name, String description, Boolean active, PageRequest pageable);
}
