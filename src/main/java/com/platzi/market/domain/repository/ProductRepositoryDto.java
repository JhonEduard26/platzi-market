package com.platzi.market.domain.repository;

import com.platzi.market.domain.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryDto {
    List<ProductDto> getAll();
    List<ProductDto> getByCategory(int categoryId);
    Optional<List<ProductDto>> getScarceProducts(int quantity);
    Optional<ProductDto> getProduct(int productId);
    ProductDto save(ProductDto productDto);
    void delete(int productId);
}
