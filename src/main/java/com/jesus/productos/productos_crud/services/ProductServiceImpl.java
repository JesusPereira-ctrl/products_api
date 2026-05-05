package com.jesus.productos.productos_crud.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jesus.productos.productos_crud.dtos.request.ProductRequestDto;
import com.jesus.productos.productos_crud.dtos.response.CategoryResponseDto;
import com.jesus.productos.productos_crud.dtos.response.ProductResponseDto;
import com.jesus.productos.productos_crud.entities.Category;
import com.jesus.productos.productos_crud.entities.Product;
import com.jesus.productos.productos_crud.exceptions.NotFoundException;
import com.jesus.productos.productos_crud.repositories.CategoryRepository;
import com.jesus.productos.productos_crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<ProductResponseDto> findAll(Pageable pageable) {
        return this.productRepository.findAll(pageable)
                .map(this::toDto);
    }

    @Override
    public ProductResponseDto findById(Long id) {
        return toDto(
                this.productRepository.findById(id).orElseThrow(
                        () -> new NotFoundException("Producto no encontrado")));
    }

    @Override
    public ProductResponseDto save(ProductRequestDto product) {
        Product productNew = new Product();
        productNew.setName(product.getName());
        productNew.setDescription(product.getDescription());
        productNew.setStock(product.getStock());

        List<Category> categories = this.categoryRepository.findAllByIdIn(product.getCategoryIds());

        if (categories.isEmpty()) {
            throw new NotFoundException("No se encontraron categorías");
        }

        productNew.setCategories(categories);

        return toDto(productRepository.save(productNew));
    }

    @Override
    public ProductResponseDto update(Long id, ProductRequestDto product) {
        Product productDB = this.productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Producto no encontrado"));

        productDB.setName(product.getName());
        productDB.setDescription(product.getDescription());
        productDB.setStock(product.getStock());

        List<Category> categories = this.categoryRepository.findAllByIdIn(product.getCategoryIds());

        if (categories.isEmpty()) {
            throw new NotFoundException("No se encontraron categorías");
        }

        productDB.setCategories(categories);

        return toDto(this.productRepository.save(productDB));
    }

    @Override
    public void deleteById(Long id) {
        Product productDB = this.productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Producto no encontrado"));

        this.productRepository.delete(productDB);
    }

    private ProductResponseDto toDto(Product product) {
        ProductResponseDto productoDto = new ProductResponseDto();
        productoDto.setId(product.getId());
        productoDto.setName(product.getName());
        productoDto.setStock(product.getStock());
        productoDto.setDescription(product.getDescription());

        List<CategoryResponseDto> categoriesDto = new ArrayList<>();

        product.getCategories().forEach(category -> {
            CategoryResponseDto dto = new CategoryResponseDto();
            dto.setId(category.getId());
            dto.setName(category.getName());
            categoriesDto.add(dto);
        });

        productoDto.setCategories(categoriesDto);

        return productoDto;
    }
}
