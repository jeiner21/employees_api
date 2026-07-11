# Prueba Técnica - Employee Benefits API

API REST desarrollada con Spring Boot para la gestión de empleados y sus beneficios.

## Tecnologías utilizadas

* Java 17
* Spring Boot 4.1.0
* Spring Data JPA
* PostgreSQL
* Lombok
* Maven
* OpenStreetMap Nominatim API

## Características

* CRUD completo de empleados.
* CRUD completo de beneficios.
* Relación entre empleados y beneficios.
* Validación de datos de entrada.
* Manejo global de excepciones.
* Respuestas mediante DTOs.
* Mapper para transformación de entidades.
* Consumo de API externa para consulta de ubicaciones mediante OpenStreetMap.

## Arquitectura del proyecto

```
controller
    ↓
service
    ↓
mapper
    ↓
repository
    ↓
database
```

## Estructura de paquetes

```
com.proyecto.pruebaTecnica

├── client
├── config
├── controller
├── dto
│   ├── request
│   └── response
├── entity
├── exception
├── mapper
├── repository
└── service
    └── impl
```

## Configuración de base de datos

Crear una base de datos PostgreSQL:

```
employee_dashboard
```

Configurar las propiedades en:

```
application.properties
```

copialo y pegalo y cambio tu usuario y contraseña de postgresql:

```properties
spring.application.name=pruebaTecnica
spring.datasource.url=jdbc:postgresql://localhost:5432/employee_dashboard
spring.datasource.username=tuUsuario
spring.datasource.password=tuPasword
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Ejecutar proyecto

Clonar repositorio:

```bash
git clone https://github.com/jeiner21/employees_api/
```

Entrar al proyecto:

```bash
cd pruebaTecnica
```

Ejecutar:

```bash
mvn spring-boot:run
```

La API estará disponible en:

```
http://localhost:8080
```

## Endpoints principales

### Employees

Obtener todos:

```
GET /employees
```

Obtener por ID:

```
GET /employees/{id}
```

Crear:

```
POST /employees
```

Actualizar:

```
PUT /employees/{id}
```

Eliminar:

```
DELETE /employees/{id}
```

---

### Benefits

Obtener todos:

```
GET /benefits
```

Obtener beneficios de un empleado:

```
GET /benefits/employee/{employeeId}
```

Crear:

```
POST /benefits
```

Actualizar:

```
PUT /benefits/{id}
```

Eliminar:

```
DELETE /benefits/{id}
```

## OpenStreetMap

La aplicación consume Nominatim de OpenStreetMap para consultar información geográfica de ciudades.

Ejemplo:

```
GET /locations?city=Bogota
```

## Autor

Jeiner Arenas

Desarrollador Java Backend Junior





















































