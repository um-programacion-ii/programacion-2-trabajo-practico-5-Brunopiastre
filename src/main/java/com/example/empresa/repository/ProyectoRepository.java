package com.example.empresa.repository;

import com.example.empresa.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {

    @Query("SELECT p FROM Proyecto p WHERE p.fechaFin > :hoy")
    List<Proyecto> findActivos(@Param("hoy") LocalDate hoy);
}
