package com.jesus.productos.productos_crud.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.productos.productos_crud.dtos.request.ProductRequestDto;
import com.jesus.productos.productos_crud.dtos.response.ProductResponseDto;
import com.jesus.productos.productos_crud.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductResponseDto> getAll(Pageable pageable) {
        return this.productService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getMethodName(@PathVariable Long id) {
        return this.productService.findById(id);
    }

    @PostMapping
    public ProductResponseDto create(@Valid @RequestBody ProductRequestDto productRequestDto) {
        return this.productService.save(productRequestDto);
    }

    @PutMapping("/{id}")
    public ProductResponseDto update(@PathVariable Long id, @Valid @RequestBody ProductRequestDto productRequestDto) {
        return this.productService.update(id, productRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
