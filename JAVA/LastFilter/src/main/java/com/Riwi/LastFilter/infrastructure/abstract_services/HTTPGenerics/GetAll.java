package com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics;

import org.springframework.data.domain.Page;


public interface GetAll<RS> {
    Page<RS> getAll(int page, int size);
}
