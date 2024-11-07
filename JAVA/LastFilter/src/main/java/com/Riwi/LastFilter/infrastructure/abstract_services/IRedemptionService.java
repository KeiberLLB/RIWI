package com.Riwi.LastFilter.infrastructure.abstract_services;

import com.Riwi.LastFilter.api.dto.request.RedemptionRequest;
import com.Riwi.LastFilter.api.dto.response.RedemptionEntityResponse;
import com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics.Create;

public interface IRedemptionService extends Create<RedemptionRequest, RedemptionEntityResponse>{
  
}
