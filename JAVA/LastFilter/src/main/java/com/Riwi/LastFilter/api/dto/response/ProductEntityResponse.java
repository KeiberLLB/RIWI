package com.Riwi.LastFilter.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntityResponse {
    private Long id;
    private String productName;
    private Double productPrice;
}
