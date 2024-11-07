package com.Riwi.LastFilter.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Riwi.LastFilter.domain.entities.ProductEntity;

public interface ProductRepository extends JpaRepository <ProductEntity , Long>{
    
}
