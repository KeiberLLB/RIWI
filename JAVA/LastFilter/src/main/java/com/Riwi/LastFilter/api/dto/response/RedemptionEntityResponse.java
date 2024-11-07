package com.Riwi.LastFilter.api.dto.response;

import com.Riwi.LastFilter.api.dto.response.basic.RedemptionEntityBasicResponse;
import com.Riwi.LastFilter.api.dto.response.basic.UserEntityBasicResponse;

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
public class RedemptionEntityResponse extends RedemptionEntityBasicResponse {
    private UserEntityBasicResponse user;
}
