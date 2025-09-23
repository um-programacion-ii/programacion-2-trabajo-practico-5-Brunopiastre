package com.example.empresa.service;

import com.example.empresa.entity.Proyecto;
import java.util.List;

public interface ProyectoService {
<<<<<<< HEAD
=======
<<<<<<< HEAD
    // Etapa 2
=======
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
>>>>>>> origin/main
    Proyecto guardar(Proyecto proyecto);
    Proyecto buscarPorId(Long id);
    List<Proyecto> obtenerTodos();
    Proyecto actualizar(Long id, Proyecto proyecto);
    void eliminar(Long id);
<<<<<<< HEAD
    List<Proyecto> buscarActivos();
=======
<<<<<<< HEAD
    List<Proyecto> obtenerActivos();

    // Controllers
    List<Proyecto> findAll();
    Proyecto findById(Long id);
    Proyecto save(Proyecto proyecto);
    Proyecto update(Long id, Proyecto proyecto);
    void delete(Long id);
=======
    List<Proyecto> buscarActivos();
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
>>>>>>> origin/main
}
