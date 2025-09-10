package com.example.empresa.service;

import com.example.empresa.entity.Empleado;
import com.example.empresa.entity.Proyecto;
import com.example.empresa.repository.EmpleadoRepository;
import com.example.empresa.repository.ProyectoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    private final EmpleadoRepository empleadoRepo;
    private final ProyectoRepository proyectoRepo;

    public EmpleadoService(EmpleadoRepository empleadoRepo, ProyectoRepository proyectoRepo) {
        this.empleadoRepo = empleadoRepo;
        this.proyectoRepo = proyectoRepo;
    }

    public List<Empleado> findAll() { return empleadoRepo.findAll(); }
    public Empleado findById(Long id) { return empleadoRepo.findById(id).orElseThrow(); }
    public Empleado save(Empleado e) { return empleadoRepo.save(e); }
    public Empleado update(Long id, Empleado data) {
        Empleado e = findById(id);
        e.setNombre(data.getNombre());
        e.setApellido(data.getApellido());
        e.setEmail(data.getEmail());
        e.setFechaContratacion(data.getFechaContratacion());
        e.setSalario(data.getSalario());
        e.setDepartamento(data.getDepartamento());
        return empleadoRepo.save(e);
    }
    public void delete(Long id) { empleadoRepo.deleteById(id); }

    public Empleado asignarProyecto(Long empleadoId, Long proyectoId) {
        Empleado e = findById(empleadoId);
        Proyecto p = proyectoRepo.findById(proyectoId).orElseThrow();
        e.getProyectos().add(p);
        return empleadoRepo.save(e);
    }
}
