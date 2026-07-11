<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import Swal from 'sweetalert2';
import { updateBenefit, getBenefitById} from '../services/benefitService';



const route = useRoute();
const router = useRouter();


const id = Number(route.params.id);
const employeeId = Number(route.query.employeeId);


const benefitName = ref('');
const amount = ref(0);
const loadBenefit = async () => {

  const benefit = await getBenefitById(id);

  benefitName.value = benefit.benefitName;
  amount.value = benefit.amount;

};
onMounted(() => {
  loadBenefit();
});

const save = async () => {

  try {

    await updateBenefit(id, {
      benefitName: benefitName.value,
      amount: amount.value,
      employeeId: employeeId
    });


    await Swal.fire({
      icon: 'success',
      title: 'Beneficio actualizado',
      text: 'Los cambios se guardaron correctamente.',
      confirmButtonColor: '#2563eb'
    });


    router.push(`/employees/${employeeId}`);


  } catch (error) {

    Swal.fire({
      icon: 'error',
      title: 'Error',
      text: 'No fue posible actualizar el beneficio.',
      confirmButtonColor: '#dc2626'
    });

    console.error(error);

  }

};

</script>

<template>

<div class="container">

    <div class="card">

        <h1>Editar Beneficio</h1>

        <form @submit.prevent="save">

            <div class="form-group">

                <label>Nombre del beneficio</label>

                <input
                    v-model="benefitName"
                    type="text"
                />

            </div>

            <div class="form-group">

                <label>Monto</label>

                <input
                    v-model="amount"
                    type="number"
                />

            </div>

            <div class="buttons">

                <button
                    class="btn btn-primary"
                    type="submit"
                >
                    Guardar cambios
                </button>

                <router-link
                    class="btn btn-secondary"
                    :to="`/employees/${employeeId}`"
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
    width:550px;
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
    width:100%;
    padding:12px;
    border:1px solid #d1d5db;
    border-radius:8px;
    font-size:16px;
    box-sizing:border-box;
}

input:focus{
    outline:none;
    border-color:#2563eb;
    box-shadow:0 0 5px rgba(37,99,235,.3);
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
    transition:.3s;
}

.btn:hover{
    opacity:.9;
    transform:translateY(-2px);
}

.btn-primary{
    background:#2563eb;
}

.btn-secondary{
    background:#6b7280;
}

</style>