package com.platzi.market.web.controller;

import com.platzi.market.domain.ProductDto;
import com.platzi.market.domain.service.ProductServiceDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Predicate;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceDto productServiceDto;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<ProductDto>> getAll(){
        return new ResponseEntity<>(productServiceDto.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with an id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found")
    })
    public ResponseEntity<ProductDto> getProduct(@ApiParam(value = "Id of the product", required = true, example = "10") @PathVariable("id") long productId){
        return ResponseEntity.of(productServiceDto.getProduct(productId));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable("id") int categoryId){
        return productServiceDto.getByCategory(categoryId)
                .filter(Predicate.not(List::isEmpty))
                .map(products -> new ResponseEntity<>(products, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productServiceDto.save(productDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") long productId){
        if (productServiceDto.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
