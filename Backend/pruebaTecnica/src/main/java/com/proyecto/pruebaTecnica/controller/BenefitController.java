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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/benefits")
@RequiredArgsConstructor
@Tag(name = "Beneficios",
    description = "Operaciones para la gestion de beneficios de los empleados"
)
public class BenefitController {
    private final BenefitService benefitService;

    @Operation(summary = "Obtener todos los beneficios")
    @GetMapping
    public ResponseEntity<List<BenefitResponse>> findAll() {
        return ResponseEntity.ok(benefitService.findAll());
    }

    @Operation(summary = "Obtener todos los beneficios por id")
    @GetMapping("/{id}")
    public ResponseEntity<BenefitResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(benefitService.findById(id));
    }

    @Operation(summary = "Obtener todos los beneficios de un empleado")
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<BenefitResponse>> findByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(benefitService.findByEmployeeId(employeeId));
    }

    @Operation(summary = "Crear un uevo beneficio")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BenefitResponse> save(@Valid @RequestBody BenefitRequest request) {
        return ResponseEntity.ok(benefitService.save(request));
    }

    @Operation(summary = "Actualizar un beneficio por id")
    @PutMapping("/{id}")
    public ResponseEntity<BenefitResponse> update(@PathVariable Long id, @Valid @RequestBody BenefitRequest request) {
        return ResponseEntity.ok(benefitService.update(id, request));
    }

    @Operation(summary = "Eliminar un beneficio por id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        benefitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
