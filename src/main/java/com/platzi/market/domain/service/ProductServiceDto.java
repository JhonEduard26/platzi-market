package com.platzi.market.domain.service;

import com.platzi.market.domain.ProductDto;
import com.platzi.market.domain.repository.ProductRepositoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceDto {

    @Autowired
    private ProductRepositoryDto productRepositoryDto;

    public List<ProductDto> getAll() {
        return productRepositoryDto.getAll();
    }

    public Optional<ProductDto> getProduct(long productId) {
        return productRepositoryDto.getProduct(productId);
    }

    public Optional<List<ProductDto>> getByCategory(int categoryId) {
        return productRepositoryDto.getByCategory(categoryId);
    }

    public ProductDto save(ProductDto productDto){
        return productRepositoryDto.save(productDto);
    }

    public boolean delete(long productId){
        return getProduct(productId).map(product -> {
            productRepositoryDto.delete(productId);
            return true;
        }).orElse(false);
    }

}
