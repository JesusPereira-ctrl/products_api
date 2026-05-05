package com.jesus.productos.productos_crud.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jesus.productos.productos_crud.dtos.request.ProductRequestDto;
import com.jesus.productos.productos_crud.dtos.response.ProductResponseDto;

public interface ProductService {

    Page<ProductResponseDto> findAll(Pageable pageable);

    ProductResponseDto findById(Long id);

    ProductResponseDto save(ProductRequestDto product);

    ProductResponseDto update(Long id, ProductRequestDto product);

    void deleteById(Long id);
}
