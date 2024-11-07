package com.Riwi.LastFilter.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.Riwi.LastFilter.api.dto.request.RedemptionRequest;
import com.Riwi.LastFilter.api.dto.response.RedemptionEntityResponse;
import com.Riwi.LastFilter.domain.entities.RedemptionEntity;

@Mapper(componentModel = "spring")
public interface RedemptionEntityMapper {

    RedemptionEntityResponse toEntityResponse(RedemptionEntity redemptionEntity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "totalValue", ignore = true),
            @Mapping(target = "redemptionDate", ignore = true),
            @Mapping(target = "product.id", source = "productId"),
            @Mapping(target = "user.id", source = "userId"),
            @Mapping(target = "coupon.couponCode", source = "couponCode"),
    })
    RedemptionEntity toEntity(RedemptionRequest redemptionRequest);

}
