<script setup lang="ts">
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import { useRouter } from 'vue-router';
import { createBenefit } from '../services/benefitService';
import type { Employee } from '../interfaces/Employee';
import { getEmployeeById, deleteEmployee } from '../services/employeeService';
import { deleteBenefit } from '../services/benefitService';
import Swal from 'sweetalert2';




const route = useRoute();
const router = useRouter();



const employee = ref<Employee | null>(null);


const loadEmployee = async () => {
  const id = Number(route.params.id);
  employee.value = await getEmployeeById(id);
};


onMounted(() => {
  loadEmployee();
});
const benefitName = ref('');
const amount = ref(0);

const saveBenefit = async () => {

  if (!employee.value) return;

  try {

    await createBenefit({
      benefitName: benefitName.value,
      amount: amount.value,
      employeeId: employee.value.id
    });

    await Swal.fire({
      icon: 'success',
      title: 'Beneficio agregado',
      text: 'El beneficio fue registrado correctamente.',
      confirmButtonColor: '#2563eb'
    });

    benefitName.value = '';
    amount.value = 0;

    await loadEmployee();

  } catch (error) {

    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'No fue posible agregar el beneficio.'
    });

    console.error(error);

  }

};

const removeEmployee = async () => {

  if (!employee.value) return;

  const result = await Swal.fire({
    title: '¿Eliminar empleado?',
    text: 'Esta acción no se puede deshacer.',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#dc2626',
    cancelButtonColor: '#6b7280',
    confirmButtonText: 'Sí, eliminar',
    cancelButtonText: 'Cancelar'
  });

  if (!result.isConfirmed) return;

  try {

    await deleteEmployee(employee.value.id);

    await Swal.fire({
      icon: 'success',
      title: 'Empleado eliminado',
      text: 'El empleado fue eliminado correctamente.',
      confirmButtonColor: '#2563eb'
    });

    router.push('/');

  } catch (error) {

    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'No fue posible eliminar el empleado.'
    });

    console.error(error);

  }

};
const removeBenefit = async (id: number) => {

  const result = await Swal.fire({
    title: '¿Eliminar beneficio?',
    text: 'Esta acción no se puede deshacer.',
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#dc2626',
    cancelButtonColor: '#6b7280',
    confirmButtonText: 'Sí, eliminar',
    cancelButtonText: 'Cancelar'
  });

  if (!result.isConfirmed) return;

  try {

    await deleteBenefit(id);

    await Swal.fire({
      icon: 'success',
      title: 'Beneficio eliminado',
      text: 'El beneficio fue eliminado correctamente.',
      confirmButtonColor: '#2563eb'
    });

    await loadEmployee();

  } catch (error) {

    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'No fue posible eliminar el beneficio.'
    });

    console.error(error);

  }

};
</script>

<template>
  <div v-if="employee" class="container">

    <div class="card">

      <div class="header">

        <h1>{{ employee.name }}</h1>

        <div>

          <router-link
            class="btn btn-warning"
            :to="`/employees/edit/${employee.id}`"
          >
            Editar
          </router-link>

          <button
            class="btn btn-danger"
            @click="removeEmployee"
          >
            Eliminar
          </button>

        </div>

      </div>

      <div class="info">

        <p><strong>Email:</strong> {{ employee.email }}</p>

        <p><strong>Ciudad:</strong> {{ employee.city }}</p>

        <p><strong>Latitud:</strong> {{ employee.latitude }}</p>

        <p><strong>Longitud:</strong> {{ employee.longitude }}</p>

      </div>

    </div>

    <div class="card">

      <h2>Beneficios</h2>

      <ul class="benefits">

        <li
          v-for="benefit in employee.benefits"
          :key="benefit.id"
        >

          <div>

            <strong>{{ benefit.benefitName }}</strong>

            <p>${{ benefit.amount }}</p>

          </div>

          <div>

            <router-link
              class="btn btn-warning"
              :to="`/benefits/edit/${benefit.id}?employeeId=${employee.id}`"
            >
              Editar
            </router-link>

            <button
              class="btn btn-danger"
              @click="removeBenefit(benefit.id)"
            >
              Eliminar
            </button>

          </div>

        </li>

      </ul>

    </div>

    <div class="card">

      <h2>Agregar beneficio</h2>

      <form @submit.prevent="saveBenefit">

        <input
          v-model="benefitName"
          placeholder="Nombre del beneficio"
        />

        <input
          v-model="amount"
          type="number"
          placeholder="Monto"
        />

        <button
          class="btn btn-primary"
          type="submit"
        >
          Guardar beneficio
        </button>

      </form>

    </div>

  </div>
</template>
<style scoped>

.container{
    max-width:1100px;
    margin:40px auto;
}

.card{
    background:white;
    border-radius:15px;
    padding:25px;
    margin-bottom:25px;
    box-shadow:0 8px 20px rgba(0,0,0,.08);
}

.header{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:20px;
}

.info p{
    margin:10px 0;
    font-size:17px;
}

.benefits{
    list-style:none;
    padding:0;
}

.benefits li{
    display:flex;
    justify-content:space-between;
    align-items:center;
    padding:15px;
    border-radius:10px;
    margin-bottom:10px;
    background:#f8fafc;
}

input{
    width:100%;
    padding:12px;
    margin-bottom:15px;
    border:1px solid #d1d5db;
    border-radius:8px;
    font-size:16px;
}

.btn{
    padding:10px 18px;
    border:none;
    border-radius:8px;
    cursor:pointer;
    color:white;
    text-decoration:none;
    margin-right:10px;
    font-weight:bold;
}

.btn-primary{
    background:#2563eb;
}

.btn-warning{
    background:#f59e0b;
    padding:10px 18px;
}

.btn-danger{
    background:#dc2626;
    padding:10px 18px;
}

.btn:hover{
    opacity:.9;
}

</style>