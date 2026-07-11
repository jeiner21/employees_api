# Employees Benefits

Aplicación web para la gestión de empleados y sus beneficios.

El proyecto está dividido en dos partes:

- Backend: API REST desarrollada con Java y Spring Boot.
- Frontend: Aplicación web desarrollada con Vue 3 y TypeScript.

Permite realizar operaciones CRUD de empleados y beneficios, además de consultar información de ubicación del empleado.

---

# Arquitectura del proyecto


employees-benefits
│
├── Backend
│ └── pruebaTecnica
│ └── API REST Spring Boot
│
├── Frontend
│ └── pruebaTecnicaFrontend
│ └── Aplicación Vue 3
│
└── README.md


---

# Tecnologías utilizadas

## Backend

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- REST API
- Lombok
- Validaciones con Jakarta 
- Swagger/OpenAPI
  

## Frontend

- Vue 3
- TypeScript
- Vite
- Vue Router
- Axios
- SweetAlert2
- CSS3

---

# Funcionalidades

## Empleados

- Crear empleados.
- Consultar empleados.
- Ver detalle del empleado.
- Editar empleados.
- Eliminar empleados.

## Beneficios

- Crear beneficios.
- Consultar beneficios por empleado.
- Editar beneficios.
- Eliminar beneficios.

## Ubicación

- Consulta de coordenadas mediante integración con OpenStreetMap.

---

# Instalación y ejecución

## 1. Clonar repositorio

```bash
git clone https://github.com/jeiner21/employees_api/
Backend

Ingresar a la carpeta:

cd Backend/pruebaTecnica

Configurar la base de datos PostgreSQL en:

application.properties

Ejecutar:

./mvnw spring-boot:run

El backend estará disponible en:

http://localhost:8080
Frontend

Ingresar a la carpeta:

cd Frontend/pruebaTecnicaFrontend

Instalar dependencias:

npm install

Ejecutar:

npm run dev

El frontend estará disponible en:

http://localhost:5173
Endpoints principales
Employees
GET    /api/employees
GET    /api/employees/{id}
POST   /api/employees
PUT    /api/employees/{id}
DELETE /api/employees/{id}
Benefits
GET    /api/benefits
GET    /api/benefits/{id}
GET    /api/benefits/employee/{employeeId}
POST   /api/benefits
PUT    /api/benefits/{id}
DELETE /api/benefits/{id}
Pruebas

El proyecto está preparado para agregar pruebas unitarias utilizando:

JUnit
Mockito
 Autor

Jeiner Arenas

Desarrollador Backend Java / Spring Boot y Frontend Vue.
