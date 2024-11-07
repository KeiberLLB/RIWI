package com.Riwi.LastFilter.infrastructure.helpers.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.Riwi.LastFilter.api.dto.request.UserRequest;
import com.Riwi.LastFilter.api.dto.response.UserEntityResponse;
import com.Riwi.LastFilter.domain.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    UserEntityResponse toEntityResponse(UserEntity userEntity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "redemptions", ignore = true)
    })
    UserEntity toEntity(UserRequest userRequest);

}
