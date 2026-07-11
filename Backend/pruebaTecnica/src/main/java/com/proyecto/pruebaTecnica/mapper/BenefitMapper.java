package com.proyecto.pruebaTecnica.mapper;

import org.springframework.stereotype.Component;

import com.proyecto.pruebaTecnica.dto.response.BenefitResponse;
import com.proyecto.pruebaTecnica.entity.Benefit;

@Component
public class BenefitMapper {

    public BenefitResponse toResponse(Benefit benefit) {
        return BenefitResponse.builder()
                .id(benefit.getId())
                .benefitName(benefit.getBenefitName())
                .amount(benefit.getAmount())
                .employeeId(benefit.getEmployee().getId())
                .build();
    }
}
