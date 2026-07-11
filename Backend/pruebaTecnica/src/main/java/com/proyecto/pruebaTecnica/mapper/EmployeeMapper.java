package com.proyecto.pruebaTecnica.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.pruebaTecnica.dto.response.EmployeeResponse;
import com.proyecto.pruebaTecnica.entity.Employee;

@Component
public class EmployeeMapper {

    public EmployeeResponse toResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .city(employee.getCity())
                .build();
    }
}
