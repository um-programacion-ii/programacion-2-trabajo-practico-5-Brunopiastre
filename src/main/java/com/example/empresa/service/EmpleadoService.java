package com.example.empresa.service;

import com.example.empresa.entity.Empleado;
import java.math.BigDecimal;
import java.util.List;

public interface EmpleadoService {
    // Nombres Etapa 2
    Empleado guardar(Empleado empleado);
    Empleado buscarPorId(Long id);
    List<Empleado> buscarPorDepartamento(String nombreDepartamento);
    List<Empleado> buscarPorRangoSalario(BigDecimal salarioMin, BigDecimal salarioMax);
    BigDecimal obtenerSalarioPromedioPorDepartamento(Long departamentoId);
    List<Empleado> obtenerTodos();
    Empleado actualizar(Long id, Empleado empleado);
    void eliminar(Long id);

    // Nombres que usan los controllers
    List<Empleado> findAll();
    Empleado findById(Long id);
    Empleado save(Empleado empleado);
    Empleado update(Long id, Empleado empleado);
    void delete(Long id);

    // Extra usado por EmpleadoController
    Empleado asignarProyecto(Long empleadoId, Long proyectoId);
}
