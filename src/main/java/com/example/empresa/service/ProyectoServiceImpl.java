package com.example.empresa.service;

import com.example.empresa.entity.Proyecto;
import com.example.empresa.exception.ProyectoNoEncontradoException;
import com.example.empresa.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class ProyectoServiceImpl implements ProyectoService {
    private final ProyectoRepository repo;

    public ProyectoServiceImpl(ProyectoRepository repo) { this.repo = repo; }

    @Override
    public Proyecto guardar(Proyecto proyecto) { return repo.save(proyecto); }

    @Override
    public Proyecto buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() ->
            new ProyectoNoEncontradoException("Proyecto no encontrado con ID: " + id));
    }

    @Override
    public List<Proyecto> obtenerTodos() { return repo.findAll(); }

    @Override
    public Proyecto actualizar(Long id, Proyecto proyecto) {
        if (!repo.existsById(id)) throw new ProyectoNoEncontradoException("Proyecto no encontrado con ID: " + id);
        proyecto.setId(id);
        return repo.save(proyecto);
    }

    @Override
    public void eliminar(Long id) {
        if (!repo.existsById(id)) throw new ProyectoNoEncontradoException("Proyecto no encontrado con ID: " + id);
        repo.deleteById(id);
    }

    @Override
    public List<Proyecto> buscarActivos() {
        return repo.findByFechaFinAfter(LocalDate.now());
    }
}
