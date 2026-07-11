import api from './api';
import type { Employee } from '../interfaces/Employee';

export const getEmployees = async (): Promise<Employee[]> => {
  const response = await api.get<Employee[]>('/api/employees');
  return response.data;
};
export const getEmployeeById = async (id: number): Promise<Employee> => {
  const response = await api.get<Employee>(`/api/employees/${id}`);
  return response.data;
};
export const createEmployee = async (employee: {
  name: string;
  email: string;
  city: string;
}) => {

  const response = await api.post(
    '/api/employees',
    employee
  );
  return response.data;
};
export const updateEmployee = async (
  id: number,
  employee: {
    name: string;
    email: string;
    city: string;
  }
) => {

  const response = await api.put(
    `/api/employees/${id}`,
    employee
  );

  return response.data;

};
export const deleteEmployee = async (id: number) => {

  await api.delete(`/api/employees/${id}`);

};
