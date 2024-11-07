package com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics;

public interface GetByCode <RS, Code> {
  RS findByCode(Code code);
}
