package com.example.empresa.service;

import com.example.empresa.entity.Departamento;
import com.example.empresa.entity.Empleado;
import com.example.empresa.exception.EmpleadoNoEncontradoException;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.repository.EmpleadoRepository;
import com.example.empresa.service.impl.EmpleadoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmpleadoServiceTest {

    private EmpleadoRepository empleadoRepository;
    private DepartamentoRepository departamentoRepository;
    private EmpleadoService empleadoService;

    @BeforeEach
    void setUp() {
        empleadoRepository = mock(EmpleadoRepository.class);
        departamentoRepository = mock(DepartamentoRepository.class);
        empleadoService = new EmpleadoServiceImpl(empleadoRepository, departamentoRepository, null);
    }

    @Test
    void guardar_insertaEmpleado() {
        Empleado e = new Empleado();
        e.setNombre("Ana");
        e.setApellido("García");
        e.setEmail("ana@empresa.com");
        e.setFechaContratacion(LocalDate.now());
        e.setSalario(10000.0);

        when(empleadoRepository.findByEmail("ana@empresa.com")).thenReturn(Optional.empty());
        when(empleadoRepository.save(any(Empleado.class))).thenAnswer(inv -> {
            Empleado x = inv.getArgument(0);
            x.setId(1L);
            return x;
        });

        Empleado guardado = empleadoService.guardar(e);

        assertThat(guardado.getId()).isEqualTo(1L);
        ArgumentCaptor<Empleado> captor = ArgumentCaptor.forClass(Empleado.class);
        verify(empleadoRepository).save(captor.capture());
        assertThat(captor.getValue().getEmail()).isEqualTo("ana@empresa.com");
    }

    @Test
    void buscarPorId_noExiste_lanzaExcepcion() {
        when(empleadoRepository.findById(99L)).thenReturn(Optional.empty());
        assertThatThrownBy(() -> empleadoService.buscarPorId(99L))
                .isInstanceOf(EmpleadoNoEncontradoException.class);
    }
}
