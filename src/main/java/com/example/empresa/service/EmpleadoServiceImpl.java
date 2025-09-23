package com.example.empresa.service;

import com.example.empresa.entity.Empleado;
import com.example.empresa.exception.EmailDuplicadoException;
import com.example.empresa.exception.EmpleadoNoEncontradoException;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    private final DepartamentoRepository departamentoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository,
                               DepartamentoRepository departamentoRepository) {
        this.empleadoRepository = empleadoRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public Empleado guardar(Empleado empleado) {
        if (empleado.getEmail() != null && empleadoRepository.findByEmail(empleado.getEmail()).isPresent()) {
            throw new EmailDuplicadoException("El email ya está registrado: " + empleado.getEmail());
        }
        // Validar departamento si viene con id
        if (empleado.getDepartamento() != null && empleado.getDepartamento().getId() != null) {
            Long depId = empleado.getDepartamento().getId();
            departamentoRepository.findById(depId)
                    .orElseThrow(() -> new RuntimeException("Departamento no encontrado con ID: " + depId));
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado buscarPorId(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado con ID: " + id));
    }

    @Override
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
    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado actualizar(Long id, Empleado empleado) {
        if (!empleadoRepository.existsById(id)) {
            throw new EmpleadoNoEncontradoException("Empleado no encontrado con ID: " + id);
        }
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
}
