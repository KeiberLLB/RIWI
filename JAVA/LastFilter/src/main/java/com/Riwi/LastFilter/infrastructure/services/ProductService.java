package com.Riwi.LastFilter.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Riwi.LastFilter.api.dto.response.ProductEntityResponse;
import com.Riwi.LastFilter.domain.repositories.ProductRepository;
import com.Riwi.LastFilter.infrastructure.abstract_services.IProductService;
import com.Riwi.LastFilter.infrastructure.helpers.mappers.ProductEntityMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService implements IProductService {

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductEntityMapper productEntityMapper;

    
    @Override
    public Page<ProductEntityResponse> getAll(int page, int size) {
        if(page < 0){
            page = 0;
        }

        PageRequest pagination = PageRequest.of(page, size);
        return this.productRepository.findAll(pagination).map(this.productEntityMapper::toEntityResponse);
    }
        
}
