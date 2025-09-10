package com.example.empresa.service.impl;

import com.example.empresa.entity.Departamento;
import com.example.empresa.exception.DepartamentoNoEncontradoException;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.service.DepartamentoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository departamentoRepository;

    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

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
}
