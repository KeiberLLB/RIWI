package com.Riwi.LastFilter.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RedemptionRequest {
    
    private Long productId;

    private String couponCode;

    private Long userId;

}
