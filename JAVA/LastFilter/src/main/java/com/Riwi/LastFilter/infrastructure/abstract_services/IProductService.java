package com.Riwi.LastFilter.infrastructure.abstract_services;


import com.Riwi.LastFilter.api.dto.response.ProductEntityResponse;
import com.Riwi.LastFilter.infrastructure.abstract_services.HTTPGenerics.GetAll;

public interface IProductService extends GetAll<ProductEntityResponse> {
    
}
