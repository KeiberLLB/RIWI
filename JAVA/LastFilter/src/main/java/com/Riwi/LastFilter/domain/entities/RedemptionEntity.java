package com.Riwi.LastFilter.domain.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "redemptions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RedemptionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  @Builder.Default
  private LocalDateTime redemptionDate = LocalDateTime.now();
  @Column(nullable = false)
  private Double totalValue;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "id_product")
  private ProductEntity product;

  @ManyToOne
  @JoinColumn(name = "id_coupon")
  private CouponEntity coupon;

}
