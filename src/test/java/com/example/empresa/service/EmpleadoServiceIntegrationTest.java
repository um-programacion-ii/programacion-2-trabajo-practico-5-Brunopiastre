package com.example.empresa.service;

import com.example.empresa.entity.Departamento;
import com.example.empresa.entity.Empleado;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.repository.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class EmpleadoServiceIntegrationTest {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Test
    void cuandoGuardarEmpleado_entoncesSePersisteCorrectamente() {
        Departamento departamento = new Departamento();
        departamento.setNombre("IT");
        departamento.setDescripcion("Tecnología");
        departamento = departamentoRepository.save(departamento);

        Empleado empleado = new Empleado();
        empleado.setNombre("Juan");
        empleado.setApellido("Pérez");
        empleado.setEmail("juan.perez@empresa.com");
        empleado.setFechaContratacion(LocalDate.now());
        empleado.setSalario(50000.00);
        empleado.setDepartamento(departamento);

        Empleado guardado = empleadoService.guardar(empleado);

        assertNotNull(guardado.getId());
        assertEquals("juan.perez@empresa.com", guardado.getEmail());
        assertTrue(empleadoRepository.existsById(guardado.getId()));
    }
}
