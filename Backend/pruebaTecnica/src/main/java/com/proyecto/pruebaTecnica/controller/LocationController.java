package com.proyecto.pruebaTecnica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.pruebaTecnica.dto.response.LocationResponse;
import com.proyecto.pruebaTecnica.service.LocationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @GetMapping("/locations")
    public List<LocationResponse> searchCity(@RequestParam String city) {
        return locationService.searchCity(city);
    }
}
