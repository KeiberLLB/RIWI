package com.Riwi.LastFilter.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import com.Riwi.LastFilter.api.dto.request.CouponRequest;
import com.Riwi.LastFilter.api.dto.response.CouponEntityResponse;
import com.Riwi.LastFilter.domain.entities.CouponEntity;

@Mapper(componentModel = "spring")
public interface CouponEntityMapper {

    CouponEntityResponse toEntityResponse(CouponEntity couponEntity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    CouponEntity toEntity(CouponRequest couponRequest);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    void toExistingEntity(CouponRequest request, @MappingTarget CouponEntity couponEntity);
    
}
