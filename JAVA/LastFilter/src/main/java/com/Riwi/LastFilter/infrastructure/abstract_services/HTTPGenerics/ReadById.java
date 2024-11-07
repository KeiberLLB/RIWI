package com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics;

public interface ReadById <RS , ID> {
    RS findById(ID id);
}
