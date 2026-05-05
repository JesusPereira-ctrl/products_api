package com.jesus.productos.productos_crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesus.productos.productos_crud.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
