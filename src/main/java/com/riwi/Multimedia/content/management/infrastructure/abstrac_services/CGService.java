package com.riwi.Multimedia.content.management.infrastructure.abstrac_services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CGService<RQ, RS, ID>{

    RS create(RQ request);

    Page<RS> getAll(Pageable pageable);

    RS get(ID id);


}
