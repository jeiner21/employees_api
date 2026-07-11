<script setup lang="ts">
import { ref } from 'vue';
import { createEmployee } from '../services/employeeService';
import Swal from 'sweetalert2';

const name = ref('');
const email = ref('');
const city = ref('');

const saveEmployee = async () => {

  try {

    await createEmployee({
      name: name.value,
      email: email.value,
      city: city.value
    });


    await Swal.fire({
      icon: 'success',
      title: 'Empleado creado',
      text: 'El empleado fue registrado correctamente.',
      confirmButtonColor: '#2563eb'
    });


    name.value = '';
    email.value = '';
    city.value = '';


  } catch (error) {

    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'No fue posible crear el empleado.',
      confirmButtonColor: '#dc2626'
    });

    console.error(error);

  }

};
</script>

<template>

<div class="container">

<div class="card">

<h1>Crear Empleado</h1>

<form @submit.prevent="saveEmployee">

<div class="form-group">

<label>Nombre</label>

<input
v-model="name"
type="text"
placeholder="Ingrese el nombre"
/>

</div>

<div class="form-group">

<label>Email</label>

<input
v-model="email"
type="email"
placeholder="Ingrese el correo"
/>

</div>

<div class="form-group">

<label>Ciudad</label>

<input
v-model="city"
type="text"
placeholder="Ingrese la ciudad"
/>

</div>

<div class="buttons">

<button
class="btn btn-primary"
type="submit"
>
Guardar
</button>

<router-link
class="btn btn-secondary"
to="/"
>
Cancelar
</router-link>

</div>

</form>

</div>

</div>

</template>
<style scoped>

.container{
    display:flex;
    justify-content:center;
    margin-top:50px;
}

.card{
    width:500px;
    background:white;
    border-radius:15px;
    padding:30px;
    box-shadow:0 10px 25px rgba(0,0,0,.1);
}

h1{
    text-align:center;
    margin-bottom:25px;
    color:#1f2937;
}

.form-group{
    display:flex;
    flex-direction:column;
    margin-bottom:18px;
}

label{
    margin-bottom:8px;
    font-weight:bold;
    color:#374151;
}

input{
    padding:12px;
    border:1px solid #d1d5db;
    border-radius:8px;
    font-size:16px;
}

input:focus{
    outline:none;
    border-color:#2563eb;
}

.buttons{
    display:flex;
    justify-content:space-between;
    margin-top:20px;
}

.btn{
    padding:12px 20px;
    border:none;
    border-radius:8px;
    cursor:pointer;
    text-decoration:none;
    color:white;
    font-weight:bold;
}

.btn-primary{
    background:#2563eb;
}

.btn-secondary{
    background:#6b7280;
}

.btn:hover{
    opacity:.9;
}

</style>