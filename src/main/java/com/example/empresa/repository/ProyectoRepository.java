package com.example.empresa.repository;

import com.example.empresa.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
=======
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)

import java.time.LocalDate;
import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
<<<<<<< HEAD

    @Query("SELECT p FROM Proyecto p WHERE p.fechaFin > :hoy")
    List<Proyecto> findActivos(@Param("hoy") LocalDate hoy);
=======
    List<Proyecto> findByFechaFinAfter(LocalDate fecha);
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
}
