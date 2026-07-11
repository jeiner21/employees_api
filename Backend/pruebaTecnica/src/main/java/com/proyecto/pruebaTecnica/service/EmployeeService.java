package com.proyecto.pruebaTecnica.service;

import java.util.List;

import com.proyecto.pruebaTecnica.dto.request.EmployeeRequest;
import com.proyecto.pruebaTecnica.dto.response.EmployeeDetailResponse;
import com.proyecto.pruebaTecnica.dto.response.EmployeeResponse;


public interface EmployeeService {
    List<EmployeeResponse> findAll();

    EmployeeDetailResponse findById(Long id);

    EmployeeResponse save(EmployeeRequest request);

    EmployeeResponse update(Long id, EmployeeRequest request);

    void deleteById(Long id);

}
