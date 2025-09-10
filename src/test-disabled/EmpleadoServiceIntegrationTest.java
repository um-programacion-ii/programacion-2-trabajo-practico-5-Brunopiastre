package com.example.empresa.service;

import com.example.empresa.entity.Departamento;
import com.example.empresa.entity.Empleado;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.service.exception.EmailDuplicadoException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("dev")
class EmpleadoServiceIntegrationTest {

    @Autowired EmpleadoService empleadoService;
    @Autowired DepartamentoRepository departamentoRepository;

    private Empleado nuevo(String email, Departamento dpto, String salario) {
        Empleado e = new Empleado();
        e.setNombre("Test");
        e.setApellido("User");
        e.setEmail(email);
        e.setFechaContratacion(LocalDate.now());
        e.setSalario(new BigDecimal(salario));
        e.setDepartamento(dpto);
        return e;
    }

    @Test
    void guardaCalculaPromedioYLanzaDuplicado() {
        Departamento ventas = new Departamento();
        ventas.setNombre("Ventas");
        ventas.setDescripcion("Depto Ventas");
        ventas = departamentoRepository.save(ventas);

        empleadoService.guardar(nuevo("a@empresa.com", ventas, "1000.00"));
        empleadoService.guardar(nuevo("b@empresa.com", ventas, "3000.00"));

        var promedio = empleadoService.obtenerSalarioPromedioPorDepartamento(ventas.getId());
        assertThat(promedio).isEqualByComparingTo(new BigDecimal("2000.00"));

        assertThrows(EmailDuplicadoException.class,
            () -> empleadoService.guardar(nuevo("a@empresa.com", ventas, "5000.00")));
    }
}
