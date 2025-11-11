package com.example.empresa.service;

import com.example.empresa.entity.Empleado;
import com.example.empresa.entity.Proyecto;
import com.example.empresa.repository.EmpleadoRepository;
import com.example.empresa.repository.ProyectoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProyectoMemberService {

    private final ProyectoRepository proyectoRepository;
    private final EmpleadoRepository empleadoRepository;

    public ProyectoMemberService(ProyectoRepository proyectoRepository,
                                 EmpleadoRepository empleadoRepository) {
        this.proyectoRepository = proyectoRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public Proyecto agregarEmpleado(Long proyectoId, Long empleadoId) {
        Proyecto p = proyectoRepository.findById(proyectoId)
            .orElseThrow(() -> new IllegalArgumentException("Proyecto no encontrado"));
        Empleado e = empleadoRepository.findById(empleadoId)
            .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"));

        p.getEmpleados().add(e);
        e.getProyectos().add(p);

        proyectoRepository.save(p);
        empleadoRepository.save(e);

        return p;
    }
}
