package com.proyecto.pruebaTecnica.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.pruebaTecnica.client.LocationClient;
import com.proyecto.pruebaTecnica.dto.response.LocationResponse;
import com.proyecto.pruebaTecnica.service.LocationService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService{
    private final LocationClient locationClient;

    @Override
    public List<LocationResponse> searchCity(String city){
        return locationClient.getLocation(city);
    }
}
