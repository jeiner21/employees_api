package com.proyecto.pruebaTecnica.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.pruebaTecnica.client.LocationClient;
import com.proyecto.pruebaTecnica.dto.request.EmployeeRequest;
import com.proyecto.pruebaTecnica.entity.Employee;
import com.proyecto.pruebaTecnica.exception.ResourceNotFoundException;
import com.proyecto.pruebaTecnica.repository.EmployeeRepository;
import com.proyecto.pruebaTecnica.service.EmployeeService;
import com.proyecto.pruebaTecnica.mapper.EmployeeMapper;
import com.proyecto.pruebaTecnica.dto.response.BenefitResponse;
import com.proyecto.pruebaTecnica.dto.response.EmployeeDetailResponse;
import com.proyecto.pruebaTecnica.dto.response.EmployeeResponse;
import com.proyecto.pruebaTecnica.dto.response.LocationResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final LocationClient locationClient;

    @Override
    public List<EmployeeResponse> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::toResponse)
                .collect(Collectors.toList());

    }

    @Override
public EmployeeDetailResponse findById(Long id) {

    Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                    "Employee not found with id: " + id
            ));

    LocationResponse location = null;

    var locations = locationClient.getLocation(employee.getCity());

    if (locations != null && !locations.isEmpty()) {
        location = locations.get(0);
    }

    List<BenefitResponse> benefits = employee.getBenefits()
            .stream()
            .map(benefit -> BenefitResponse.builder()
                    .id(benefit.getId())
                    .benefitName(benefit.getBenefitName())
                    .amount(benefit.getAmount())
                    .employeeId(employee.getId())
                    .build())
            .collect(Collectors.toList());


    return EmployeeDetailResponse.builder()
            .id(employee.getId())
            .name(employee.getName())
            .email(employee.getEmail())
            .city(employee.getCity())
            .latitude(location != null ? location.getLat() : null)
            .longitude(location != null ? location.getLon() : null)
            .benefits(benefits)
            .build();
}

    @Override
    public EmployeeResponse save(EmployeeRequest request) {
        Employee employee = Employee.builder()
                .name(request.getName())
                .email(request.getEmail())
                .city(request.getCity())
                .build();
        Employee saved = employeeRepository.save(employee);
        return employeeMapper.toResponse(saved);
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id:" + id));
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setCity(request.getCity());

        Employee update = employeeRepository.save(employee);
        return employeeMapper.toResponse(update);
    }

    @Override
    public void deleteById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employeeRepository.delete(employee);
    }
}
