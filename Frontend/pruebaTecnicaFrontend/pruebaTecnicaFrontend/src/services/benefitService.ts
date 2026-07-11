import api from './api';

export const createBenefit = async (benefit: {
  benefitName: string;
  amount: number;
  employeeId: number;
}) => {

  const response = await api.post(
    '/api/benefits',
    benefit
  );

  return response.data;
};
export const updateBenefit = async (
  id: number,
  benefit: {
    benefitName: string;
    amount: number;
    employeeId: number;
  }
) => {

  const response = await api.put(
    `/api/benefits/${id}`,
    benefit
  );

  return response.data;

};
export const deleteBenefit = async (id: number) => {

  await api.delete(`/api/benefits/${id}`);

};
export const getBenefitById = async (id: number) => {

  const response = await api.get(
    `/api/benefits/${id}`
  );

  return response.data;

};