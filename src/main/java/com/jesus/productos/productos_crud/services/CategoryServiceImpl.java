package com.jesus.productos.productos_crud.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jesus.productos.productos_crud.dtos.request.CategoryRequestDto;
import com.jesus.productos.productos_crud.dtos.response.CategoryResponseDto;
import com.jesus.productos.productos_crud.entities.Category;
import com.jesus.productos.productos_crud.exceptions.NotFoundException;
import com.jesus.productos.productos_crud.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository repository;

    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<CategoryResponseDto> findAll(Pageable pageable) {
        return this.repository.findAll(pageable).map(this::toDto);
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        return this.toDto(this.repository.findById(id).orElseThrow(
                () -> new NotFoundException("Categoria no encontrada")));
    }

    @Override
    public CategoryResponseDto create(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        return toDto(this.repository.save(category));
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryRequestDto categoryRequestDto) {
        Category categoryDB = this.repository.findById(id).orElseThrow(
                () -> new NotFoundException("Categoria no encontrada"));

        categoryDB.setName(categoryRequestDto.getName());

        return toDto(this.repository.save(categoryDB));
    }

    @Override
    public void deleteById(Long id) {
        Category categoryDB = this.repository.findById(id).orElseThrow(
                () -> new NotFoundException("Categoria no encontrada"));

        this.repository.delete(categoryDB);
    }

    private CategoryResponseDto toDto(Category category) {
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

}
