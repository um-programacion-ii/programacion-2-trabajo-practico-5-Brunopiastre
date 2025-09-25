package com.example.empresa.service.impl;

import com.example.empresa.entity.Departamento;
import com.example.empresa.exception.DepartamentoNoEncontradoException;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.service.DepartamentoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    // Etapa 2 (español)
    @Override
    public Departamento guardar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    @Override
    public Departamento buscarPorId(Long id) {
        return departamentoRepository.findById(id)
                .orElseThrow(() -> new DepartamentoNoEncontradoException("Departamento no encontrado con ID: " + id));
    }

    @Override
    public Departamento buscarPorNombre(String nombre) {
        return departamentoRepository.findByNombre(nombre)
                .orElseThrow(() -> new DepartamentoNoEncontradoException("Departamento no encontrado con nombre: " + nombre));
    }

    @Override
    public List<Departamento> obtenerTodos() {
        return departamentoRepository.findAll();
    }

    @Override
    public Departamento actualizar(Long id, Departamento departamento) {
        Departamento existente = departamentoRepository.findById(id)
                .orElseThrow(() -> new DepartamentoNoEncontradoException("Departamento no encontrado con ID: " + id));
        existente.setNombre(departamento.getNombre());
        existente.setDescripcion(departamento.getDescripcion());
        return departamentoRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Departamento existente = departamentoRepository.findById(id)
                .orElseThrow(() -> new DepartamentoNoEncontradoException("Departamento no encontrado con ID: " + id));
        departamentoRepository.delete(existente);
    }

    // Controllers (delegan)
    @Override
    public List<Departamento> findAll() { return obtenerTodos(); }

    @Override
    public Departamento findById(Long id) { return buscarPorId(id); }

    @Override
    public Departamento save(Departamento d) { return guardar(d); }

    @Override
    public Departamento update(Long id, Departamento d) { return actualizar(id, d); }

    @Override
    public void delete(Long id) { eliminar(id); }
}
