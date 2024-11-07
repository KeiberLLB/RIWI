package com.Riwi.LastFilter.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "coupons")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CouponEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, length = 150)
  private String couponCode;
  @Column(nullable = false, length = 150)
  private String description;
  @Column(nullable = false)
  private Double discount;
  @Column(nullable = false)
  private Boolean isActive;
  @Builder.Default
  private LocalDateTime createdAt = LocalDateTime.now();
  @Column(nullable = true)
  private LocalDateTime updatedAt;
  @Column(nullable = false)
  private LocalDateTime expiresDate;
}
