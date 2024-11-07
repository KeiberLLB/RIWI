package com.Riwi.LastFilter.api.controllers;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Riwi.LastFilter.api.dto.response.ProductEntityResponse;
import com.Riwi.LastFilter.infrastructure.abstract_services.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/products")
@AllArgsConstructor
public class ProdcutController{

    @Autowired
    private final IProductService productService;
    
        @Operation(summary = "List all products with pagination", 
                    description = "You must send the page and size to receive all corresponding products.")
    @GetMapping
    public ResponseEntity<Page<ProductEntityResponse>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size) {
        return ResponseEntity.ok(this.productService.getAll(page - 1, size));
    }

}
