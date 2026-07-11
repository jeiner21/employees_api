package com.proyecto.pruebaTecnica.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.pruebaTecnica.dto.request.BenefitRequest;
import com.proyecto.pruebaTecnica.dto.response.BenefitResponse;
import com.proyecto.pruebaTecnica.entity.Benefit;
import com.proyecto.pruebaTecnica.entity.Employee;
import com.proyecto.pruebaTecnica.exception.ResourceNotFoundException;
import com.proyecto.pruebaTecnica.mapper.BenefitMapper;
import com.proyecto.pruebaTecnica.repository.BenefitRepository;
import com.proyecto.pruebaTecnica.repository.EmployeeRepository;
import com.proyecto.pruebaTecnica.service.BenefitService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;
    private final EmployeeRepository employeeRepository;
    private final BenefitMapper benefitMapper;

    @Override
    public List<BenefitResponse> findAll() {
        return benefitRepository.findAll()
                .stream()
                .map(benefitMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BenefitResponse findById(Long id) {

        Benefit benefit = benefitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Benefit not found with id: " + id));

        return benefitMapper.toResponse(benefit);
    }

    @Override
    public List<BenefitResponse> findByEmployeeId(Long employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new ResourceNotFoundException("Employee not found with id: " + employeeId);
        }
        return benefitRepository.findByEmployeeId(employeeId)
                .stream()
                .map(benefitMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BenefitResponse save(BenefitRequest request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee not found with id: " + request.getEmployeeId()));
        Benefit benefit = Benefit.builder()
                .benefitName(request.getBenefitName())
                .amount(request.getAmount())
                .employee(employee)
                .build();
        Benefit saved = benefitRepository.save(benefit);
        return benefitMapper.toResponse(saved);
    }

    @Override
    public BenefitResponse update(Long id, BenefitRequest request) {
        Benefit benefit = benefitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Benefit not found with id: " + id));
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee not found with id: " + request.getEmployeeId()));
        benefit.setBenefitName(request.getBenefitName());
        benefit.setAmount(request.getAmount());
        benefit.setEmployee(employee);
        Benefit update = benefitRepository.save(benefit);
        return benefitMapper.toResponse(update);
    }

    @Override
    public void deleteById(Long id) {
        Benefit benefit = benefitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Benefit not found with id: " + id));
        benefitRepository.delete(benefit);
    }

}
