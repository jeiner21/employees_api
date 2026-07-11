# Employees Benefits - Frontend

Aplicación web para la gestión de empleados y sus beneficios.  
Permite administrar empleados, consultar sus detalles, gestionar beneficios asociados y visualizar información de ubicación.

** Tecnologías utilizadas

- Vue 3
- TypeScript
- Vite
- Vue Router
- Axios
- SweetAlert2
- CSS3

** Funcionalidades

** Gestión de empleados

- Listar empleados.
- Ver detalle de empleados.
- Crear empleados.
- Editar empleados.
- Eliminar empleados.
- Consultar ubicación del empleado mediante coordenadas.

** Gestión de beneficios

- Crear beneficios asociados a empleados.
- Listar beneficios por empleado.
- Editar beneficios.
- Eliminar beneficios.

** Arquitectura del proyecto

El proyecto está organizado siguiendo una estructura basada en componentes y separación de responsabilidades:


src
│
├── components
│
├── views
│ ├── EmployeesView.vue
│ ├── EmployeeDetailView.vue
│ ├── CreateEmployeeView.vue
│ ├── EditEmployeeView.vue
│ └── EditBenefitView.vue
│
├── services
│ ├── employeeService.ts
│ └── benefitService.ts
│
├── interfaces
│
├── router
│
└── assets


** Instalación y configuración

Clonar el repositorio:

```bash
git clone https://github.com/jeiner21/employees_api/

Ingresar a la carpeta del proyecto:

cd pruebaTecnicaFrontend

Instalar dependencias:

npm install
** Ejecutar aplicación

Para iniciar el servidor de desarrollo:

npm run dev

La aplicación estará disponible en:

http://localhost:5173
** Compilación para producción

Generar archivos optimizados:

npm run build
** Backend

Este frontend consume una API REST desarrollada con:

Java
Spring Boot
PostgreSQL

El backend debe estar ejecutándose previamente para poder realizar las operaciones CRUD.

** Integraciones
Axios para comunicación con la API REST.
Vue Router para navegación entre vistas.
SweetAlert2 para mensajes de confirmación y notificaciones.
OpenStreetMap para obtener información de ubicación.
** Interfaz

La aplicación cuenta con:

Diseño moderno y limpio.
Menú de navegación horizontal fijo.
Tablas para administración de empleados.
Formularios de creación y edición.
Confirmaciones antes de eliminar registros.
Mensajes visuales de éxito y error.
Scripts disponibles
Desarrollo
npm run dev
Producción
npm run build
Vista previa de producción
npm run preview

Desarrollado Por Jeiner Arenas Backend Java / Spring Boot y Frontend Vue.
