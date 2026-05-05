# products_api

Proyecto personal hecho con Spring Boot 4 para aplicar lo aprendido

## Que incluye el proyecto

1. Patron Dto para requests y responses

2. Arquitectura por capas (service controller, repository)

3. Manejo de errores

4. Relaciones muchos a muchos con Spring Data JPA

5. Contenerizacion con Docker

6. Paginacion

7. Documentacion con OpenAPI Swagger

## Ejecutar Proyecto

cambiar varibles en caso de puertos usados en `docker-compose.yml`

1. Levantar base de datos y proyecto

   ```bash
   docker compose up -d
   ```

2. Ver documentacion en la URL `http://localhost:8080/swagger-ui/index.html`

## Estructura del proyecto

```text
│───── 📁 com
│       └── 📁 jesus
│           └── 📁 productos
│               └── 📁 productos_crud
│                   ├── 📁 controllers -> endpoints
│                   │   ├── ☕ CategoryController.java
│                   │   └── ☕ ProductController.java
│                   ├── 📁 dtos -> patron dto
│                   │   ├── 📁 request
│                   │   │   ├── ☕ CategoryRequestDto.java
│                   │   │   └── ☕ ProductRequestDto.java
│                   │   └── 📁 response
│                   │       ├── ☕ CategoryResponseDto.java
│                   │       └── ☕ ProductResponseDto.java
│                   ├── 📁 entities -> entidades base de datos
│                   │   ├── ☕ Category.java
│                   │   └── ☕ Product.java
│                   ├── 📁 exceptions -> manejo de excepciones
│                   │   ├── ☕ GlobalExceptionHandler.java
│                   │   └── ☕ NotFoundException.java
│                   ├── 📁 repositories -> capa de repositorio acceso a datos
│                   │   ├── ☕ CategoryRepository.java
│                   │   └── ☕ ProductRepository.java
│                   ├── 📁 services -> capa de servicio lógica de negocio
│                   │   ├── ☕ CategoryService.java
│                   │   ├── ☕ CategoryServiceImpl.java
│                   │   ├── ☕ ProductService.java
│                   │   └── ☕ ProductServiceImpl.java
│                   ├── ☕ AppConfig.java --> configuracion extra swagger
│                   └── ☕ ProductosCrudApplication.java
└── 📁 resources -> recursos de configuracion y población de datos
    ├── 📁 static
    ├── 📁 templates
    ├── 📄 application-dev.properties
    ├── 📄 application.properties
    └── 📄 data.sql
```
