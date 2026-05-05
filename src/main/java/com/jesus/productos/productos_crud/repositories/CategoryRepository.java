package com.jesus.productos.productos_crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesus.productos.productos_crud.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByIdIn(List<Long> ids);
}
