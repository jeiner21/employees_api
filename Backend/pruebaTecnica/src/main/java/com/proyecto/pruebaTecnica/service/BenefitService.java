package com.proyecto.pruebaTecnica.service;

import java.util.List;

import com.proyecto.pruebaTecnica.dto.request.BenefitRequest;
import com.proyecto.pruebaTecnica.dto.response.BenefitResponse;


public interface BenefitService {

    List<BenefitResponse> findAll();
    
    BenefitResponse findById(Long id);

    List<BenefitResponse> findByEmployeeId(Long employeeId);

    BenefitResponse save(BenefitRequest request);

    BenefitResponse update(Long id, BenefitRequest request);

    void deleteById(Long id);
}
