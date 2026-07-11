package com.proyecto.pruebaTecnica.dto.response;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BenefitResponse {

    private Long id;
    private String benefitName;
    private Double amount;
    private Long employeeId;
    
}
