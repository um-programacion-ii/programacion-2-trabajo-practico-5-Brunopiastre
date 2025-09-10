package com.example.empresa.service;

import com.example.empresa.entity.Departamento;
import java.util.List;

public interface DepartamentoService {
    // Etapa 2
    Departamento guardar(Departamento departamento);
    Departamento buscarPorId(Long id);
    List<Departamento> obtenerTodos();
    Departamento actualizar(Long id, Departamento departamento);
    void eliminar(Long id);

    // Controllers
    List<Departamento> findAll();
    Departamento findById(Long id);
    Departamento save(Departamento departamento);
    Departamento update(Long id, Departamento departamento);
    void delete(Long id);
}
