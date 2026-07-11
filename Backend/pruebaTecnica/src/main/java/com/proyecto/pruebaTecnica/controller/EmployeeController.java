package com.proyecto.pruebaTecnica.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.pruebaTecnica.dto.request.EmployeeRequest;
import com.proyecto.pruebaTecnica.dto.response.EmployeeDetailResponse;
import com.proyecto.pruebaTecnica.dto.response.EmployeeResponse;
import com.proyecto.pruebaTecnica.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
@Tag(name = "Empleados",
    description = "Operaciones para la gestion de empleados"
)
public class EmployeeController {

    private final EmployeeService employeeService;

    @Operation(summary = "Obtener todos los empleados")
    @GetMapping
    ResponseEntity<List<EmployeeResponse>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @Operation(summary = "Obtener un empleado por id")
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDetailResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @Operation(summary = "Crear un nuevo empleado")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeResponse> save(@Valid @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.save(request));
    }

    @Operation(summary = "Actualizar un empleado")
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> update(@PathVariable Long id, @Valid @RequestBody EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.update(id, request));
    }

    @Operation(summary = "Eliminar un empleado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
