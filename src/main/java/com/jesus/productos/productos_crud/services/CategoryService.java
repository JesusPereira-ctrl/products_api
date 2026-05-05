package com.jesus.productos.productos_crud.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jesus.productos.productos_crud.dtos.request.CategoryRequestDto;
import com.jesus.productos.productos_crud.dtos.response.CategoryResponseDto;

public interface CategoryService {
    Page<CategoryResponseDto> findAll(Pageable pageable);

    CategoryResponseDto getById(Long id);

    CategoryResponseDto create(CategoryRequestDto categoryRequestDto);

    CategoryResponseDto update(Long id, CategoryRequestDto categoryRequestDto);

    void deleteById(Long id);
}
