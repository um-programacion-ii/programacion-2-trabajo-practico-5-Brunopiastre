package com.example.empresa.service;

import com.example.empresa.entity.Proyecto;
import com.example.empresa.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {
    private final ProyectoRepository repo;
    public ProyectoService(ProyectoRepository repo){ this.repo = repo; }

    public List<Proyecto> findAll(){ return repo.findAll(); }
    public Proyecto findById(Long id){ return repo.findById(id).orElseThrow(); }
    public Proyecto save(Proyecto p){ return repo.save(p); }
    public Proyecto update(Long id, Proyecto data){
        Proyecto p = findById(id);
        p.setNombre(data.getNombre());
        p.setDescripcion(data.getDescripcion());
        p.setFechaInicio(data.getFechaInicio());
        p.setFechaFin(data.getFechaFin());
        return repo.save(p);
    }
    public void delete(Long id){ repo.deleteById(id); }
}
