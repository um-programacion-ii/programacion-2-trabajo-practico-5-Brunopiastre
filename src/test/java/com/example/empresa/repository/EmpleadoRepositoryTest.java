package com.example.empresa.repository;

import com.example.empresa.entity.Departamento;
import com.example.empresa.entity.Empleado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmpleadoRepositoryTest {

    @Autowired
    EmpleadoRepository empleadoRepository;
    @Autowired
    DepartamentoRepository departamentoRepository;

    @Test
    void findByEmail_ok() {
        Departamento dep = new Departamento();
        dep.setNombre("IT");
        dep.setDescripcion("Tecnología");
        dep = departamentoRepository.save(dep);

        Empleado e = new Empleado();
        e.setNombre("Juan");
        e.setApellido("Pérez");
        e.setEmail("juan@empresa.com");
        e.setFechaContratacion(LocalDate.now());
        e.setSalario(12345.67);
        e.setDepartamento(dep);
        empleadoRepository.save(e);

        Optional<Empleado> encontrado = empleadoRepository.findByEmail("juan@empresa.com");
        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getDepartamento().getNombre()).isEqualTo("IT");
    }

    @Test
    void findByNombreDepartamento_ok() {
        Departamento dep = new Departamento();
        dep.setNombre("RRHH");
        dep.setDescripcion("Recursos Humanos");
        dep = departamentoRepository.save(dep);

        Empleado a = new Empleado();
        a.setNombre("Ana");
        a.setApellido("García");
        a.setEmail("a@empresa.com");
        a.setFechaContratacion(LocalDate.now());
        a.setSalario(10000.0);
        a.setDepartamento(dep);
        empleadoRepository.save(a);

        Empleado b = new Empleado();
        b.setNombre("Beto");
        b.setApellido("López");
        b.setEmail("b@empresa.com");
        b.setFechaContratacion(LocalDate.now());
        b.setSalario(11000.0);
        b.setDepartamento(dep);
        empleadoRepository.save(b);

        List<Empleado> lista = empleadoRepository.findByNombreDepartamento("RRHH");
        assertThat(lista).hasSize(2);
    }
}
