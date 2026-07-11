package com.proyecto.pruebaTecnica.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import com.proyecto.pruebaTecnica.dto.response.LocationResponse;

@Component
public class LocationClient {
    private final RestClient restClient;

    public LocationClient(RestClient.Builder builder) {

        this.restClient = builder
                .baseUrl("https://nominatim.openstreetmap.org")
                .defaultHeader("User-Agent", "pruebaTecnica")
                .build();
    }

    public List<LocationResponse> getLocation(String city) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("city", city)
                        .queryParam("format", "json")
                        .build())
                .retrieve()
                .body(new ParameterizedTypeReference<List<LocationResponse>>() {
                });

    }
}
