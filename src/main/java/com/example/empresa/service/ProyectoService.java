package com.example.empresa.service;

import com.example.empresa.entity.Proyecto;
import java.util.List;

public interface ProyectoService {
    // Etapa 2
    Proyecto guardar(Proyecto proyecto);
    Proyecto buscarPorId(Long id);
    List<Proyecto> obtenerTodos();
    Proyecto actualizar(Long id, Proyecto proyecto);
    void eliminar(Long id);
    List<Proyecto> obtenerActivos();

    // Controllers
    List<Proyecto> findAll();
    Proyecto findById(Long id);
    Proyecto save(Proyecto proyecto);
    Proyecto update(Long id, Proyecto proyecto);
    void delete(Long id);
}
