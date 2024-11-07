package com.Riwi.LastFilter.infrastructure.abstract_services;

import com.Riwi.LastFilter.api.dto.request.CouponRequest;
import com.Riwi.LastFilter.api.dto.response.CouponEntityResponse;
import com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics.Create;
import com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics.Delete;
import com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics.GetByCode;
import com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics.Update;

public interface ICouponService extends Create<CouponRequest, CouponEntityResponse>,
    Update<CouponRequest, CouponEntityResponse, Long>,
    Delete<Long>, GetByCode<CouponEntityResponse, String> {

}
