package com.jesus.productos.productos_crud.dtos.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequestDto {

    @NotEmpty(message = "El nombre de la categoría no puede ser vacía")
    @Length(min = 10, message = "La categoría debe tener minimo 10 caracteres")
    private String name;
}
