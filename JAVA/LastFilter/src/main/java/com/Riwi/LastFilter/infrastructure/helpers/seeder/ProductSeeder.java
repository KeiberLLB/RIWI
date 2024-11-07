package com.Riwi.LastFilter.infrastructure.helpers.seeder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.Riwi.LastFilter.domain.entities.ProductEntity;
import com.Riwi.LastFilter.domain.repositories.ProductRepository;

@Component
public class ProductSeeder implements CommandLineRunner{
    
    private final ProductRepository productRepository;

    public ProductSeeder(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        List<ProductEntity> products = new ArrayList<>();

        for(int i = 1;i <= 10;i++){
            ProductEntity productEntity = new ProductEntity();

            productEntity.setProductName("Product seeder number" + i);
            productEntity.setProductPrice(Double.valueOf(1000));
            productEntity.setIsActive(true);
            productEntity.setCreatedAt(LocalDateTime.now());
            productEntity.setUpdatedAt(LocalDateTime.now());

            products.add(productEntity);
        }

        productRepository.saveAll(products);

        System.out.println("10 stores created succefully");
    }

}
