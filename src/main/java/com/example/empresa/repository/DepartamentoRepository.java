package com.example.empresa.repository;

import com.example.empresa.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> { }
=======
import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Optional<Departamento> findByNombre(String nombre);
}
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
