package com.proyecto.pruebaTecnica.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BenefitRequest {
    @NotBlank(message = "Benefit name is required")
    private String benefitName;
    @NotNull(message = "Amount is required")
    private Double amount;
    @NotNull(message = "Employee ID is required")
    private Long employeeId;

}
