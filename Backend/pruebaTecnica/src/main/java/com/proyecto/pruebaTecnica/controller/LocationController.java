package com.proyecto.pruebaTecnica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.pruebaTecnica.dto.response.LocationResponse;
import com.proyecto.pruebaTecnica.service.LocationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(
    name = "Ubicaciones",
    description = "Consulta de ciudades mediante OpenStreetMap"
)

public class LocationController {

    private final LocationService locationService;

    @Operation(summary = "Buscar coordenadas de una ciudad")
    @GetMapping("/locations")
    public List<LocationResponse> searchCity(@RequestParam String city) {
        return locationService.searchCity(city);
    }
}
