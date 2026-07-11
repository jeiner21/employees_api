package com.proyecto.pruebaTecnica.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyecto.pruebaTecnica.client.LocationClient;
import com.proyecto.pruebaTecnica.dto.request.EmployeeRequest;
import com.proyecto.pruebaTecnica.dto.response.EmployeeResponse;
import com.proyecto.pruebaTecnica.entity.Employee;
import com.proyecto.pruebaTecnica.exception.ResourceNotFoundException;
import com.proyecto.pruebaTecnica.mapper.EmployeeMapper;
import com.proyecto.pruebaTecnica.repository.EmployeeRepository;
import com.proyecto.pruebaTecnica.service.impl.EmployeeServiceImpl;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @Mock
    private LocationClient locationClient;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldCreateEmployeeSuccessfully() {

        EmployeeRequest request = EmployeeRequest.builder()
                .name("Jeiner")
                .email("jeiner@gmail.com")
                .city("Abrego")
                .build();

        Employee employee = Employee.builder()
                .id(1L)
                .name("Jeiner")
                .email("jeiner@gmail.com")
                .city("Abrego")
                .build();

        EmployeeResponse response = EmployeeResponse.builder()
                .id(1L)
                .name("Jeiner")
                .email("jeiner@gmail.com")
                .city("Abrego")
                .build();

        when(employeeRepository.save(any(Employee.class)))
                .thenReturn(employee);

        when(employeeMapper.toResponse(employee))
                .thenReturn(response);

        EmployeeResponse result = employeeService.save(request);

        assertNotNull(result);
        assertEquals("Jeiner", result.getName());

        verify(employeeRepository)
                .save(any(Employee.class));

    }

    @Test
    void shouldThrowExceptionWhenEmployeeNotFound() {

        when(employeeRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> employeeService.update(
                        1L,
                        new EmployeeRequest()));

        verify(employeeRepository)
                .findById(1L);

    }

    @Test
    void shouldUpdateEmployeeSuccessfully() {

        Long id = 1L;

        Employee employee = Employee.builder()
                .id(id)
                .name("Nombre anterior")
                .email("correo@gmail.com")
                .city("Abrego")
                .build();

        EmployeeRequest request = EmployeeRequest.builder()
                .name("Nombre actualizado")
                .email("nuevo@gmail.com")
                .city("Ocaña")
                .build();

        Employee updatedEmployee = Employee.builder()
                .id(id)
                .name("Nombre actualizado")
                .email("nuevo@gmail.com")
                .city("Ocaña")
                .build();

        EmployeeResponse response = EmployeeResponse.builder()
                .id(id)
                .name("Nombre actualizado")
                .email("nuevo@gmail.com")
                .city("Ocaña")
                .build();

        when(employeeRepository.findById(id))
                .thenReturn(Optional.of(employee));

        when(employeeRepository.save(employee))
                .thenReturn(updatedEmployee);

        when(employeeMapper.toResponse(updatedEmployee))
                .thenReturn(response);

        EmployeeResponse result = employeeService.update(id, request);

        assertNotNull(result);
        assertEquals("Nombre actualizado", result.getName());
        assertEquals("Ocaña", result.getCity());

        verify(employeeRepository).findById(id);
        verify(employeeRepository).save(employee);
        verify(employeeMapper).toResponse(updatedEmployee);

    }
    @Test
void shouldDeleteEmployeeSuccessfully() {

    Long id = 1L;

    Employee employee = Employee.builder()
            .id(id)
            .name("Jeiner")
            .email("jeiner@gmail.com")
            .city("Abrego")
            .build();


    when(employeeRepository.findById(id))
            .thenReturn(Optional.of(employee));


    employeeService.deleteById(id);


    verify(employeeRepository)
            .findById(id);


    verify(employeeRepository)
            .delete(employee);

}
}