package com.example.empresa.repository;

import com.example.empresa.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
=======
<<<<<<< HEAD
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> { }
=======
>>>>>>> origin/main
import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Optional<Departamento> findByNombre(String nombre);
}
<<<<<<< HEAD
=======
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
>>>>>>> origin/main
