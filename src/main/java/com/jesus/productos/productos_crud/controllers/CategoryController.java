package com.jesus.productos.productos_crud.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.productos.productos_crud.dtos.request.CategoryRequestDto;
import com.jesus.productos.productos_crud.dtos.response.CategoryResponseDto;
import com.jesus.productos.productos_crud.services.CategoryService;

import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Page<CategoryResponseDto> getAll(Pageable pageable) {
        return this.categoryService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getById(@PathVariable Long id) {
        return this.categoryService.getById(id);
    }

    @PostMapping
    public CategoryResponseDto create(@Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return categoryService.create(categoryRequestDto);
    }

    @PutMapping("/{id}")
    public CategoryResponseDto update(@PathVariable Long id,
            @Valid @RequestBody CategoryRequestDto categoryRequestDto) {
        return this.categoryService.update(id, categoryRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
