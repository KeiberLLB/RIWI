package com.Riwi.LastFilter.api.dto.response;

import java.util.List;

import com.Riwi.LastFilter.api.dto.response.basic.UserEntityBasicResponse;
import com.Riwi.LastFilter.domain.entities.RedemptionEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntityResponse extends UserEntityBasicResponse {
    private List<RedemptionEntity> redemptions;
}
