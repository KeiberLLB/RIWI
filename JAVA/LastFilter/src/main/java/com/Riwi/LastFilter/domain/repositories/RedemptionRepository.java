package com.Riwi.LastFilter.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Riwi.LastFilter.domain.entities.RedemptionEntity;

@Repository
public interface RedemptionRepository extends JpaRepository<RedemptionEntity, Long>  {
  
}
