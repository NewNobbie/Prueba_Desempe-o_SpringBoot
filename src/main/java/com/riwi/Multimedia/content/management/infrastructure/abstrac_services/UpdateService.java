package com.riwi.Multimedia.content.management.infrastructure.abstrac_services;

public interface UpdateService<RQ, RS, ID> {

    RS update(ID id, RQ request);


}
