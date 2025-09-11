package com.example.empresa.service;

import com.example.empresa.entity.Empleado;
import java.math.BigDecimal;
import java.util.List;

public interface EmpleadoService {
    Empleado guardar(Empleado empleado);
    Empleado buscarPorId(Long id);
    List<Empleado> obtenerTodos();
    Empleado actualizar(Long id, Empleado empleado);
    void eliminar(Long id);
    List<Empleado> buscarPorDepartamento(String nombreDepartamento);
    List<Empleado> buscarPorRangoSalario(BigDecimal min, BigDecimal max);
    java.math.BigDecimal obtenerSalarioPromedioPorDepartamento(Long departamentoId);
}
