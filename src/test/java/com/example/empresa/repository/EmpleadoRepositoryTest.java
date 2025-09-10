package com.example.empresa.repository;

import com.example.empresa.entity.Departamento;
import com.example.empresa.entity.Empleado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmpleadoRepositoryTest {

    @Autowired EmpleadoRepository empleadoRepository;
    @Autowired DepartamentoRepository departamentoRepository;

    @Test
    void guardaYBuscaPorEmail_yPorNombreDepartamento() {
        Departamento it = new Departamento();
        it.setNombre("IT");
        it.setDescripcion("Tecnología");
        it = departamentoRepository.save(it);

        Empleado e = new Empleado();
        e.setNombre("Juan");
        e.setApellido("Pérez");
        e.setEmail("juan.perez@empresa.com");
        e.setFechaContratacion(LocalDate.now());
        e.setSalario(50000.00);
        e.setDepartamento(it);
        empleadoRepository.save(e);

        Optional<Empleado> porEmail = empleadoRepository.findByEmail("juan.perez@empresa.com");
        assertThat(porEmail).isPresent();

        List<Empleado> porDepto = empleadoRepository.findByNombreDepartamento("IT");
        assertThat(porDepto).extracting("email").contains("juan.perez@empresa.com");
    }
}
