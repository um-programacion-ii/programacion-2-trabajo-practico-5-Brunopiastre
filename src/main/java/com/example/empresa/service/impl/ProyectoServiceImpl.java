package com.example.empresa.service.impl;

import com.example.empresa.entity.Proyecto;
import com.example.empresa.exception.ProyectoNoEncontradoException;
import com.example.empresa.repository.ProyectoRepository;
import com.example.empresa.service.ProyectoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public Proyecto guardar(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    @Override
    public Proyecto buscarPorId(Long id) {
        return proyectoRepository.findById(id)
                .orElseThrow(() -> new ProyectoNoEncontradoException("Proyecto no encontrado con ID: " + id));
    }

    @Override
    public List<Proyecto> obtenerTodos() {
        return proyectoRepository.findAll();
    }

    @Override
    public Proyecto actualizar(Long id, Proyecto proyecto) {
        Proyecto existente = proyectoRepository.findById(id)
                .orElseThrow(() -> new ProyectoNoEncontradoException("Proyecto no encontrado con ID: " + id));
        existente.setNombre(proyecto.getNombre());
        existente.setDescripcion(proyecto.getDescripcion());
        existente.setFechaInicio(proyecto.getFechaInicio());
        existente.setFechaFin(proyecto.getFechaFin());
        existente.setEmpleados(proyecto.getEmpleados());
        return proyectoRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Proyecto existente = proyectoRepository.findById(id)
                .orElseThrow(() -> new ProyectoNoEncontradoException("Proyecto no encontrado con ID: " + id));
        proyectoRepository.delete(existente);
    }

    @Override
    public List<Proyecto> obtenerActivos() {
        LocalDate hoy = LocalDate.now();
        return proyectoRepository.findActivos(hoy);
    }
}
