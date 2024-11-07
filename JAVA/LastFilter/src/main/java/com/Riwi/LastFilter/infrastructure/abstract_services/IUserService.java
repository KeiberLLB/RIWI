package com.Riwi.LastFilter.infrastructure.abstract_services;

import java.util.List;

import com.Riwi.LastFilter.api.dto.request.UserRequest;
import com.Riwi.LastFilter.api.dto.response.RedemptionEntityResponse;
import com.Riwi.LastFilter.api.dto.response.basic.UserEntityBasicResponse;
import com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics.Create;
import com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics.GetRedemptionByUser;

public interface IUserService extends Create<UserRequest, UserEntityBasicResponse>, GetRedemptionByUser<List<RedemptionEntityResponse>, Long>{
  
}
