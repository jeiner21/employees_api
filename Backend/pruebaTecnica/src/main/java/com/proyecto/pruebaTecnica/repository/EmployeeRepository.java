package com.proyecto.pruebaTecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.pruebaTecnica.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
