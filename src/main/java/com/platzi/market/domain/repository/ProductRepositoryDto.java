package com.platzi.market.domain.repository;

import com.platzi.market.domain.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryDto {
    List<ProductDto> getAll();
    Optional<List<ProductDto>> getByCategory(int categoryId);
    Optional<List<ProductDto>> getScarceProducts(int quantity);
    Optional<ProductDto> getProduct(long productId);
    ProductDto save(ProductDto productDto);
    void delete(long productId);
}
