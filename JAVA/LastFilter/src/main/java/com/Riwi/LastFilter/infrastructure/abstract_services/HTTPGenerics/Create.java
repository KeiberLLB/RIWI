package com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics;

public interface Create <RQ,RS> {
    RS create(RQ rq);
}