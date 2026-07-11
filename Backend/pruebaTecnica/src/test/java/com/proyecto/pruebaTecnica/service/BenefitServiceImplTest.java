package com.proyecto.pruebaTecnica.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.proyecto.pruebaTecnica.dto.request.BenefitRequest;
import com.proyecto.pruebaTecnica.dto.response.BenefitResponse;
import com.proyecto.pruebaTecnica.entity.Benefit;
import com.proyecto.pruebaTecnica.entity.Employee;
import com.proyecto.pruebaTecnica.exception.ResourceNotFoundException;
import com.proyecto.pruebaTecnica.mapper.BenefitMapper;
import com.proyecto.pruebaTecnica.repository.BenefitRepository;
import com.proyecto.pruebaTecnica.repository.EmployeeRepository;
import com.proyecto.pruebaTecnica.service.impl.BenefitServiceImpl;


class BenefitServiceImplTest {


    @Mock
    private BenefitRepository benefitRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private BenefitMapper benefitMapper;


    @InjectMocks
    private BenefitServiceImpl benefitService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void shouldCreateBenefitSuccessfully() {


        BenefitRequest request = BenefitRequest.builder()
                .benefitName("Auxilio transporte")
                .amount(20000.0)
                .employeeId(1L)
                .build();


        Employee employee = Employee.builder()
                .id(1L)
                .name("Jeiner")
                .build();


        Benefit benefit = Benefit.builder()
                .id(1L)
                .benefitName("Auxilio transporte")
                .amount(20000.0)
                .employee(employee)
                .build();


        BenefitResponse response = BenefitResponse.builder()
                .id(1L)
                .benefitName("Auxilio transporte")
                .amount(20000.0)
                .employeeId(1L)
                .build();


        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));


        when(benefitRepository.save(any(Benefit.class)))
                .thenReturn(benefit);


        when(benefitMapper.toResponse(benefit))
                .thenReturn(response);


        BenefitResponse result = benefitService.save(request);


        assertNotNull(result);
        assertEquals("Auxilio transporte", result.getBenefitName());


        verify(employeeRepository).findById(1L);
        verify(benefitRepository).save(any(Benefit.class));

    }



    @Test
    void shouldNotCreateBenefitWhenEmployeeDoesNotExist() {


        BenefitRequest request = BenefitRequest.builder()
                .benefitName("Bonificacion")
                .amount(50000.0)
                .employeeId(1L)
                .build();


        when(employeeRepository.findById(1L))
                .thenReturn(Optional.empty());


        assertThrows(
                ResourceNotFoundException.class,
                () -> benefitService.save(request)
        );


        verify(employeeRepository).findById(1L);

    }



    @Test
    void shouldFindBenefitByIdSuccessfully() {


        Long id = 1L;


        Benefit benefit = Benefit.builder()
                .id(id)
                .benefitName("Auxilio")
                .amount(20000.0)
                .build();


        BenefitResponse response = BenefitResponse.builder()
                .id(id)
                .benefitName("Auxilio")
                .amount(20000.0)
                .build();



        when(benefitRepository.findById(id))
                .thenReturn(Optional.of(benefit));


        when(benefitMapper.toResponse(benefit))
                .thenReturn(response);



        BenefitResponse result = benefitService.findById(id);



        assertNotNull(result);
        assertEquals("Auxilio", result.getBenefitName());


        verify(benefitRepository).findById(id);

    }




    @Test
    void shouldUpdateBenefitSuccessfully() {


        Long id = 1L;


        BenefitRequest request = BenefitRequest.builder()
                .benefitName("Nuevo beneficio")
                .amount(30000.0)
                .employeeId(1L)
                .build();



        Employee employee = Employee.builder()
                .id(1L)
                .name("Jeiner")
                .build();



        Benefit benefit = Benefit.builder()
                .id(id)
                .benefitName("Anterior")
                .amount(20000.0)
                .build();



        BenefitResponse response = BenefitResponse.builder()
                .id(id)
                .benefitName("Nuevo beneficio")
                .amount(30000.0)
                .build();



        when(benefitRepository.findById(id))
                .thenReturn(Optional.of(benefit));


        when(employeeRepository.findById(1L))
                .thenReturn(Optional.of(employee));


        when(benefitRepository.save(benefit))
                .thenReturn(benefit);


        when(benefitMapper.toResponse(benefit))
                .thenReturn(response);



        BenefitResponse result =
                benefitService.update(id, request);



        assertEquals(
                "Nuevo beneficio",
                result.getBenefitName()
        );


        verify(benefitRepository).save(benefit);

    }





    @Test
    void shouldThrowExceptionWhenBenefitDoesNotExist() {


        when(benefitRepository.findById(1L))
                .thenReturn(Optional.empty());


        assertThrows(
                ResourceNotFoundException.class,
                () -> benefitService.update(
                        1L,
                        new BenefitRequest()
                )
        );


        verify(benefitRepository)
                .findById(1L);

    }





    @Test
    void shouldDeleteBenefitSuccessfully() {


        Long id = 1L;


        Benefit benefit = Benefit.builder()
                .id(id)
                .benefitName("Auxilio")
                .amount(20000.0)
                .build();



        when(benefitRepository.findById(id))
                .thenReturn(Optional.of(benefit));



        benefitService.deleteById(id);



        verify(benefitRepository)
                .findById(id);


        verify(benefitRepository)
                .delete(benefit);

    }

}