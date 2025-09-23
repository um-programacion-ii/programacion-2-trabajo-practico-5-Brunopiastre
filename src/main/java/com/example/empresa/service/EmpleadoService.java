package com.example.empresa.service;

import com.example.empresa.entity.Empleado;
import java.math.BigDecimal;
import java.util.List;

public interface EmpleadoService {
<<<<<<< HEAD
=======
<<<<<<< HEAD
    // Nombres Etapa 2
>>>>>>> origin/main
    Empleado guardar(Empleado empleado);
    Empleado buscarPorId(Long id);
    List<Empleado> buscarPorDepartamento(String nombreDepartamento);
    List<Empleado> buscarPorRangoSalario(BigDecimal salarioMin, BigDecimal salarioMax);
    BigDecimal obtenerSalarioPromedioPorDepartamento(Long departamentoId);
    List<Empleado> obtenerTodos();
    Empleado actualizar(Long id, Empleado empleado);
    void eliminar(Long id);
<<<<<<< HEAD
=======

    // Nombres que usan los controllers
    List<Empleado> findAll();
    Empleado findById(Long id);
    Empleado save(Empleado empleado);
    Empleado update(Long id, Empleado empleado);
    void delete(Long id);

    // Extra usado por EmpleadoController
    Empleado asignarProyecto(Long empleadoId, Long proyectoId);
=======
    Empleado guardar(Empleado empleado);
    Empleado buscarPorId(Long id);
    List<Empleado> obtenerTodos();
    Empleado actualizar(Long id, Empleado empleado);
    void eliminar(Long id);
    List<Empleado> buscarPorDepartamento(String nombreDepartamento);
    List<Empleado> buscarPorRangoSalario(BigDecimal min, BigDecimal max);
    java.math.BigDecimal obtenerSalarioPromedioPorDepartamento(Long departamentoId);
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
>>>>>>> origin/main
}
