package com.example.empresa.service;

import com.example.empresa.dto.EmpleadoRequest;
import com.example.empresa.entity.Departamento;
import com.example.empresa.entity.Empleado;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoDeptCreatorService {

    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;

    public EmpleadoDeptCreatorService(EmpleadoRepository empleadoRepository,
                                      DepartamentoRepository departamentoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @Transactional
    public Empleado crear(EmpleadoRequest req) {
        Empleado e = new Empleado();
        e.setNombre(req.getNombre());
        e.setApellido(req.getApellido());
        e.setEmail(req.getEmail());
        e.setFechaContratacion(req.getFechaContratacion());
        e.setSalario(req.getSalario());

        if (req.getDepartamentoId() != null) {
            Departamento dep = departamentoRepository.findById(req.getDepartamentoId())
                .orElseThrow(() -> new IllegalArgumentException("Departamento no encontrado: " + req.getDepartamentoId()));
            e.setDepartamento(dep);
        }
        return empleadoRepository.save(e);
    }
}
