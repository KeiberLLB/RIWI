package com.Riwi.LastFilter.api.dto.response.basic;

import java.time.LocalDateTime;

import com.Riwi.LastFilter.api.dto.response.CouponEntityResponse;
import com.Riwi.LastFilter.api.dto.response.ProductEntityResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class RedemptionEntityBasicResponse {
   private Long id;
   private LocalDateTime redemptionDate;
   private ProductEntityResponse product;
   private CouponEntityResponse coupon;
}
