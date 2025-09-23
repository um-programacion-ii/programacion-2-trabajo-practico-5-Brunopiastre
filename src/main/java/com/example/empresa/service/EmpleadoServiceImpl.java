package com.example.empresa.service;

<<<<<<< HEAD
import com.example.empresa.entity.Empleado;
import com.example.empresa.exception.EmailDuplicadoException;
import com.example.empresa.exception.EmpleadoNoEncontradoException;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.repository.EmpleadoRepository;
=======
import com.example.empresa.entity.*;
import com.example.empresa.repository.*;
import com.example.empresa.exception.*;
>>>>>>> origin/main
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
=======
>>>>>>> origin/main

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {
<<<<<<< HEAD

    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository,
                               DepartamentoRepository departamentoRepository) {
=======
    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository, DepartamentoRepository departamentoRepository) {
>>>>>>> origin/main
        this.empleadoRepository = empleadoRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public Empleado guardar(Empleado empleado) {
<<<<<<< HEAD
        if (empleado.getEmail() != null && empleadoRepository.findByEmail(empleado.getEmail()).isPresent()) {
            throw new EmailDuplicadoException("El email ya está registrado: " + empleado.getEmail());
        }
        // Validar departamento si viene con id
        if (empleado.getDepartamento() != null && empleado.getDepartamento().getId() != null) {
            Long depId = empleado.getDepartamento().getId();
            departamentoRepository.findById(depId)
                    .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + depId));
        }
=======
        empleadoRepository.findByEmail(empleado.getEmail()).ifPresent(e -> {
            throw new EmailDuplicadoException("El email ya está registrado: " + empleado.getEmail());
        });
>>>>>>> origin/main
        return empleadoRepository.save(empleado);
    }

    @Override
<<<<<<< HEAD
    @Transactional(readOnly = true)
=======
>>>>>>> origin/main
    public Empleado buscarPorId(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado con ID: " + id));
    }

    @Override
<<<<<<< HEAD
    @Transactional(readOnly = true)
    public List<Empleado> buscarPorDepartamento(String nombreDepartamento) {
        return empleadoRepository.findByNombreDepartamento(nombreDepartamento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> buscarPorRangoSalario(BigDecimal salarioMin, BigDecimal salarioMax) {
        return empleadoRepository.findBySalarioBetween(salarioMin, salarioMax);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal obtenerSalarioPromedioPorDepartamento(Long departamentoId) {
        return empleadoRepository.findAverageSalarioByDepartamento(departamentoId).orElse(BigDecimal.ZERO);
    }

    @Override
    @Transactional(readOnly = true)
=======
>>>>>>> origin/main
    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado actualizar(Long id, Empleado empleado) {
        if (!empleadoRepository.existsById(id)) {
            throw new EmpleadoNoEncontradoException("Empleado no encontrado con ID: " + id);
        }
<<<<<<< HEAD
        // Validar email duplicado (si no es el mismo empleado)
        if (empleado.getEmail() != null) {
            Optional<Empleado> porEmail = empleadoRepository.findByEmail(empleado.getEmail());
            if (porEmail.isPresent() && !porEmail.get().getId().equals(id)) {
                throw new EmailDuplicadoException("El email ya está registrado por otro empleado: " + empleado.getEmail());
            }
        }
        // Validar departamento
        if (empleado.getDepartamento() != null && empleado.getDepartamento().getId() != null) {
            Long depId = empleado.getDepartamento().getId();
            departamentoRepository.findById(depId)
                    .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + depId));
        }
=======
>>>>>>> origin/main
        empleado.setId(id);
        return empleadoRepository.save(empleado);
    }

    @Override
    public void eliminar(Long id) {
        if (!empleadoRepository.existsById(id)) {
            throw new EmpleadoNoEncontradoException("Empleado no encontrado con ID: " + id);
        }
        empleadoRepository.deleteById(id);
    }
<<<<<<< HEAD
=======

    @Override
    public List<Empleado> buscarPorDepartamento(String nombreDepartamento) {
        return empleadoRepository.findByNombreDepartamento(nombreDepartamento);
    }

    @Override
    public List<Empleado> buscarPorRangoSalario(BigDecimal min, BigDecimal max) {
        return empleadoRepository.findBySalarioBetween(min, max);
    }

    @Override
    public BigDecimal obtenerSalarioPromedioPorDepartamento(Long departamentoId) {
        return empleadoRepository.findAverageSalarioByDepartamento(departamentoId)
                .orElse(BigDecimal.ZERO);
    }
>>>>>>> origin/main
}
