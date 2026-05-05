package com.jesus.productos.productos_crud.dtos.request;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    @NotBlank(message = "El nombre no puede ser vacio")
    @Length(min = 10, message = "El nombre debe tener minimo 10 caracteres")
    private String name;

    @NotBlank(message = "La descripción es requerida")
    @Length(min = 10, message = "La descripción debe tener minimo 10 caracteres")
    private String description;

    @NotNull(message = "El stock no puede ser nulo")
    @Min(value = 0, message = "El stock no puede ser menor a cero!")
    private Integer stock;

    @NotEmpty(message = "El producto debe tener al menos una categoría")
    private List<Long> categoryIds;
}
