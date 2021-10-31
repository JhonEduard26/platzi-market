package com.platzi.market.persistence;

import com.platzi.market.domain.ProductDto;
import com.platzi.market.domain.repository.ProductRepositoryDto;
import com.platzi.market.persistence.crud.ProductCrudRepository;
import com.platzi.market.persistence.entity.Product;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements ProductRepositoryDto {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<ProductDto> getAll(){
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        return mapper.toProductsDto(products);
    }

    @Override
    public Optional<List<ProductDto>> getByCategory(int categoryId) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProductsDto(products));
    }

    @Override
    public Optional<List<ProductDto>> getScarceProducts(int quantity) {
        Optional<List<Product>> products = productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
        return products.map(prods -> mapper.toProductsDto(prods));
    }

    @Override
    public Optional<ProductDto> getProduct(long productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProductDto(product));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = mapper.toProduct(productDto);
        return mapper.toProductDto(productCrudRepository.save(product));
    }

    @Override
    public void delete(long productId) {
        productCrudRepository.deleteById(productId);
    }
}
