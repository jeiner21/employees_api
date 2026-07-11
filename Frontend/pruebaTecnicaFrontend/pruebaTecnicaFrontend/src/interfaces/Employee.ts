export interface Employee{
    id: number;
    name: string;
    email: string;
    city: string;

    latitude?: string;
    longitude?: string;

    benefits?: Benefit[];
}

export interface Benefit{
    id: number;
    benefitName: string;
    amount: number;
    employeeId: number;

}