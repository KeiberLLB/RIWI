package com.Riwi.LastFilter.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CouponRequest {
    @Size(max = 150)
    @NotNull(message = "The couponcode cannot be empty")
    private String couponCode;
    @Size(max = 150)
    @NotNull(message = "The description cannot be empty")
    private String description;
    @Min(value = 0)
    @Max(value = 100)
    private Double discount;
    @NotNull(message = "The expiresdate cannot be empty")
    private LocalDateTime expiresDate;
    private Boolean isActive;
}
