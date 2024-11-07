package com.Riwi.LastFilter.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;

import com.Riwi.LastFilter.api.dto.response.ProductEntityResponse;
import com.Riwi.LastFilter.domain.entities.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductEntityMapper {

    ProductEntityResponse toEntityResponse(ProductEntity productEntity);

}
