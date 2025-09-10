package com.example.empresa.service.impl;

import com.example.empresa.entity.Departamento;
import com.example.empresa.entity.Empleado;
import com.example.empresa.exception.EmailDuplicadoException;
import com.example.empresa.exception.EmpleadoNoEncontradoException;
import com.example.empresa.repository.DepartamentoRepository;
import com.example.empresa.repository.EmpleadoRepository;
import com.example.empresa.service.EmpleadoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

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
        empleadoRepository.findByEmail(empleado.getEmail()).ifPresent(e -> {
            throw new EmailDuplicadoException("El email ya está registrado: " + empleado.getEmail());
        });
        if (empleado.getDepartamento() != null && empleado.getDepartamento().getId() != null) {
            Departamento depto = departamentoRepository.findById(empleado.getDepartamento().getId())
                    .orElseThrow(() -> new EmpleadoNoEncontradoException(
                            "Departamento no encontrado con ID: " + empleado.getDepartamento().getId()));
            empleado.setDepartamento(depto);
        }
        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado buscarPorId(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado con ID: " + id));
    }

    @Override
    public List<Empleado> buscarPorDepartamento(String nombreDepartamento) {
        return empleadoRepository.findByNombreDepartamento(nombreDepartamento);
    }

    @Override
    public List<Empleado> buscarPorRangoSalario(BigDecimal salarioMin, BigDecimal salarioMax) {
        return empleadoRepository.findBySalarioBetween(salarioMin, salarioMax);
    }

    @Override
    public BigDecimal obtenerSalarioPromedioPorDepartamento(Long departamentoId) {
        return empleadoRepository.findAverageSalarioByDepartamento(departamentoId)
                .orElse(BigDecimal.ZERO);
    }

    @Override
    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado actualizar(Long id, Empleado empleado) {
        Empleado existente = empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado con ID: " + id));

        if (empleado.getEmail() != null && !empleado.getEmail().equals(existente.getEmail())) {
            empleadoRepository.findByEmail(empleado.getEmail()).ifPresent(e -> {
                throw new EmailDuplicadoException("El email ya está registrado: " + empleado.getEmail());
            });
        }

        existente.setNombre(empleado.getNombre());
        existente.setApellido(empleado.getApellido());
        existente.setEmail(empleado.getEmail());
        existente.setFechaContratacion(
            empleado.getFechaContratacion() != null ? empleado.getFechaContratacion() : LocalDate.now()
        );
        existente.setSalario(empleado.getSalario());

        if (empleado.getDepartamento() != null && empleado.getDepartamento().getId() != null) {
            Departamento depto = departamentoRepository.findById(empleado.getDepartamento().getId())
                    .orElseThrow(() -> new EmpleadoNoEncontradoException(
                            "Departamento no encontrado con ID: " + empleado.getDepartamento().getId()));
            existente.setDepartamento(depto);
        } else {
            existente.setDepartamento(null);
        }

        existente.setProyectos(empleado.getProyectos());
        return empleadoRepository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        Empleado existente = empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNoEncontradoException("Empleado no encontrado con ID: " + id));
        empleadoRepository.delete(existente);
    }
}
