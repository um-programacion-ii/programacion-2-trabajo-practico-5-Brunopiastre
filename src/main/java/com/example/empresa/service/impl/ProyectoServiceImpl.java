package com.example.empresa.service.impl;

import com.example.empresa.entity.Proyecto;
import com.example.empresa.exception.ProyectoNoEncontradoException;
import com.example.empresa.repository.ProyectoRepository;
import com.example.empresa.service.ProyectoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    // Etapa 2 (español)
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

    // Controllers (delegan)
    @Override
    public List<Proyecto> findAll() { return obtenerTodos(); }

    @Override
    public Proyecto findById(Long id) { return buscarPorId(id); }

    @Override
    public Proyecto save(Proyecto p) { return guardar(p); }

    @Override
    public Proyecto update(Long id, Proyecto p) { return actualizar(id, p); }

    @Override
    public void delete(Long id) { eliminar(id); }
}
