package com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics;

public interface Update<RQ, RS, ID> {
    RS update(RQ rq,ID id);
}
