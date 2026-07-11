package com.proyecto.pruebaTecnica.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDetailResponse {

    private Long id;
    private String name;
    private String email;
    private String city;

    private String latitude;
    private String longitude;

    private List<BenefitResponse> benefits;
}