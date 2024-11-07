package com.Riwi.LastFilter.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Riwi.LastFilter.domain.entities.CouponEntity;

@Repository
public interface CouponRepository extends JpaRepository<CouponEntity, Long>  {
  public CouponEntity findByCode(String code);
}
