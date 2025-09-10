package com.example.empresa.repository;

import com.example.empresa.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> { }
