package com.proyecto.pruebaTecnica.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.pruebaTecnica.dto.request.BenefitRequest;
import com.proyecto.pruebaTecnica.dto.response.BenefitResponse;

import com.proyecto.pruebaTecnica.service.BenefitService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/benefits")
@RequiredArgsConstructor
public class BenefitController {
    private final BenefitService benefitService;

    @GetMapping
    public ResponseEntity<List<BenefitResponse>> findAll() {
        return ResponseEntity.ok(benefitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BenefitResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(benefitService.findById(id));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<BenefitResponse>> findByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(benefitService.findByEmployeeId(employeeId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BenefitResponse> save(@Valid @RequestBody BenefitRequest request) {
        return ResponseEntity.ok(benefitService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BenefitResponse> update(@PathVariable Long id, @Valid @RequestBody BenefitRequest request) {
        return ResponseEntity.ok(benefitService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        benefitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
