package com.example.empresa.repository;

import com.example.empresa.entity.Departamento;
import com.example.empresa.entity.Empleado;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmpleadoRepositoryTest {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    private Empleado buildEmpleado(String email, Departamento dep) {
        Empleado e = new Empleado();
        e.setNombre("Juan");
        e.setApellido("Pérez");
        e.setEmail(email);
        e.setFechaContratacion(LocalDate.now());
        e.setSalario(new BigDecimal("12345.67"));
        e.setDepartamento(dep);
        return e;
    }

    @Test
    @DisplayName("findByEmail devuelve empleado cuando existe")
    void findByEmail_ok() {
        Departamento dep = new Departamento();
        dep.setNombre("IT");
        dep.setDescripcion("Tecnología");
        dep = departamentoRepository.save(dep);

        Empleado e = buildEmpleado("juan@empresa.com", dep);
        empleadoRepository.save(e);

        Optional<Empleado> encontrado = empleadoRepository.findByEmail("juan@empresa.com");
        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getDepartamento().getNombre()).isEqualTo("IT");
    }

    @Test
    @DisplayName("@Query findByNombreDepartamento devuelve lista")
    void findByNombreDepartamento_ok() {
        Departamento dep = new Departamento();
        dep.setNombre("RRHH");
        dep.setDescripcion("Recursos Humanos");
        dep = departamentoRepository.save(dep);

        empleadoRepository.save(buildEmpleado("a@empresa.com", dep));
        empleadoRepository.save(buildEmpleado("b@empresa.com", dep));

        List<Empleado> lista = empleadoRepository.findByNombreDepartamento("RRHH");
        assertThat(lista).hasSize(2);
    }
}
