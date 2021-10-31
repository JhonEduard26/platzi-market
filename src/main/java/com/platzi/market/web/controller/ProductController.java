package com.platzi.market.web.controller;

import com.platzi.market.domain.ProductDto;
import com.platzi.market.domain.service.ProductServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceDto productServiceDto;

    public List<ProductDto> getAll(){
        return productServiceDto.getAll();
    }

    public Optional<ProductDto> getProduct(long productId){
        return productServiceDto.getProduct(productId);
    }

    public Optional<List<ProductDto>> getByCategory(int categoryId){
        return productServiceDto.getByCategory(categoryId);
    }

    public ProductDto save(ProductDto productDto) {
        return productServiceDto.save(productDto);
    }

    public boolean delete(long productId){
        return productServiceDto.delete(productId);
    }
}
