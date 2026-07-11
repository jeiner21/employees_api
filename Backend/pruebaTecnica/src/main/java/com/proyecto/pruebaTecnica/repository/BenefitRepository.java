package com.proyecto.pruebaTecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.pruebaTecnica.entity.Benefit;

public interface BenefitRepository extends JpaRepository<Benefit, Long> {
    List<Benefit> findByEmployeeId(Long employeeId);

}
