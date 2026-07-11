package com.proyecto.pruebaTecnica.service;

import java.util.List;

import com.proyecto.pruebaTecnica.dto.response.LocationResponse;

public interface LocationService {
    List<LocationResponse> searchCity(String city);

}
