package com.example.empresa.service;

import com.example.empresa.entity.Departamento;
import java.util.List;

public interface DepartamentoService {
    Departamento guardar(Departamento dpto);
    Departamento buscarPorId(Long id);
    Departamento buscarPorNombre(String nombre);
    List<Departamento> obtenerTodos();
    Departamento actualizar(Long id, Departamento dpto);
    void eliminar(Long id);
}
