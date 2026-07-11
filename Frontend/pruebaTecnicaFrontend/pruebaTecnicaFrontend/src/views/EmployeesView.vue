<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { getEmployees } from '../services/employeeService';
import type { Employee } from '../interfaces/Employee';


const employees = ref<Employee[]>([]);

const loadEmployees = async () => {
  employees.value = await getEmployees();
};

onMounted(() => {
  loadEmployees();
});
</script>

<template>
  <div class="container">

    <div class="header">

      <h1>Gestión de Empleados</h1>

      <router-link
        class="btn btn-primary"
        to="/employees/create"
      >
        + Nuevo empleado
      </router-link>

    </div>

    <div class="card">

      <table>

        <thead>

          <tr>
            <th>Nombre</th>
            <th>Email</th>
            <th>Ciudad</th>
            <th>Acciones</th>
          </tr>

        </thead>

        <tbody>

          <tr
            v-for="employee in employees"
            :key="employee.id"
          >

            <td>{{ employee.name }}</td>

            <td>{{ employee.email }}</td>

            <td>{{ employee.city }}</td>

            <td>

              <router-link
                class="btn btn-info"
                :to="`/employees/${employee.id}`"
              >
                Ver
              </router-link>

              <router-link
                class="btn btn-warning"
                :to="`/employees/edit/${employee.id}`"
              >
                Editar
              </router-link>

            </td>

          </tr>

        </tbody>

      </table>

    </div>

  </div>
</template>
<style scoped>

.container{
    max-width:1200px;
    margin:40px auto;
    padding:20px;
}

.header{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:25px;
}

h1{
    color:#1f2937;
}

.card{
    background:white;
    border-radius:15px;
    padding:20px;
    box-shadow:0 5px 15px rgba(0,0,0,.12);
}

table{
    width:100%;
    border-collapse:collapse;
}

th{
    background:#2563eb;
    color:white;
    padding:15px;
}

td{
    padding:15px;
    border-bottom:1px solid #e5e7eb;
}

tr:hover{
    background:#f3f4f6;
}

.btn{
    padding:8px 14px;
    border-radius:8px;
    text-decoration:none;
    color:white;
    margin-right:8px;
    font-weight:bold;
    transition:.3s;
}

.btn:hover{
    opacity:.85;
}

.btn-primary{
    background:#2563eb;
}

.btn-info{
    background:#10b981;
}

.btn-warning{
    background:#f59e0b;
}

</style>