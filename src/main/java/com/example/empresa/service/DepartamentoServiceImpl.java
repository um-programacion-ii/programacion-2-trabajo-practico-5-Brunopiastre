package com.example.empresa.service;

import com.example.empresa.entity.Departamento;
import com.example.empresa.exception.DepartamentoNoEncontradoException;
<<<<<<< HEAD
import com.example.empresa.exception.DepartamentoDuplicadoException;
=======
>>>>>>> origin/main
import com.example.empresa.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartamentoServiceImpl implements DepartamentoService {
    private final DepartamentoRepository repo;

    public DepartamentoServiceImpl(DepartamentoRepository repo) {
        this.repo = repo;
    }

    @Override
<<<<<<< HEAD
    public Departamento guardar(Departamento dpto) {
        if (repo.findByNombre(dpto.getNombre()).isPresent()) {
            throw new DepartamentoDuplicadoException(
                "El departamento '" + dpto.getNombre() + "' ya existe"
            );
        }
        return repo.save(dpto);
    }
=======
    public Departamento guardar(Departamento dpto) { return repo.save(dpto); }
>>>>>>> origin/main

    @Override
    public Departamento buscarPorId(Long id) {
        return repo.findById(id).orElseThrow(() ->
            new DepartamentoNoEncontradoException("Departamento no encontrado con ID: " + id));
    }

    @Override
    public Departamento buscarPorNombre(String nombre) {
        return repo.findByNombre(nombre).orElseThrow(() ->
            new DepartamentoNoEncontradoException("Departamento no encontrado: " + nombre));
    }

    @Override
<<<<<<< HEAD
    public List<Departamento> obtenerTodos() {
        return repo.findAll();
    }

    @Override
    public Departamento actualizar(Long id, Departamento dpto) {
        if (!repo.existsById(id)) {
            throw new DepartamentoNoEncontradoException("Departamento no encontrado con ID: " + id);
        }
=======
    public List<Departamento> obtenerTodos() { return repo.findAll(); }

    @Override
    public Departamento actualizar(Long id, Departamento dpto) {
        if (!repo.existsById(id)) throw new DepartamentoNoEncontradoException("Departamento no encontrado con ID: " + id);
>>>>>>> origin/main
        dpto.setId(id);
        return repo.save(dpto);
    }

    @Override
    public void eliminar(Long id) {
<<<<<<< HEAD
        if (!repo.existsById(id)) {
            throw new DepartamentoNoEncontradoException("Departamento no encontrado con ID: " + id);
        }
=======
        if (!repo.existsById(id)) throw new DepartamentoNoEncontradoException("Departamento no encontrado con ID: " + id);
>>>>>>> origin/main
        repo.deleteById(id);
    }
}
