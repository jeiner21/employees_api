import { createRouter, createWebHistory } from 'vue-router';
import EmployeesView from '../views/EmployeesView.vue';
import EmployeeDetailView from '../views/EmployeeDetailView.vue';
import CreateEmployee from '../views/CreateEmployee.vue';
import EditEmployeeView from '../views/EditEmployeeView.vue';
import EditBenefitView from '../views/EditBenefitView.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'employees',
      component: EmployeesView
    },
    {
  path: '/employees/:id',
  name: 'employee-detail',
  component: EmployeeDetailView
},
{
  path: '/employees/create',
  name: 'create-employee',
  component: CreateEmployee
},
{
  path: '/employees/edit/:id',
  name: 'edit-employee',
  component: EditEmployeeView
},
{
  path: '/benefits/edit/:id',
  name: 'edit-benefit',
  component: EditBenefitView
}
  ]
});


export default router;