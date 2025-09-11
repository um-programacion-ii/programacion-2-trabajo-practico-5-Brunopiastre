package com.example.empresa.controller;

import com.example.empresa.entity.Empleado;
import com.example.empresa.service.EmpleadoService;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    private final EmpleadoService service;
    public EmpleadoController(EmpleadoService service){ this.service = service; }

    @GetMapping
    public List<Empleado> listar(){ return service.findAll(); }

    @GetMapping("/{id}")
    public Empleado obtener(@PathVariable Long id){ return service.findById(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado crear(@RequestBody Empleado e){ return service.save(e); }

    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Long id, @RequestBody Empleado e){
        return service.update(id, e);
=======
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@Validated
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> obtenerTodos() {
        return empleadoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Empleado obtenerPorId(@PathVariable Long id) {
        return empleadoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado crear(@Valid @RequestBody Empleado empleado) {
        return empleadoService.guardar(empleado);
    }

    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Long id, @Valid @RequestBody Empleado empleado) {
        return empleadoService.actualizar(id, empleado);
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
<<<<<<< HEAD
    public void borrar(@PathVariable Long id){ service.delete(id); }

    // Asignar empleado a proyecto (ManyToMany)
    @PostMapping("/{empleadoId}/proyectos/{proyectoId}")
    public Empleado asignarProyecto(@PathVariable Long empleadoId, @PathVariable Long proyectoId){
        return service.asignarProyecto(empleadoId, proyectoId);
=======
    public void eliminar(@PathVariable Long id) {
        empleadoService.eliminar(id);
    }

    @GetMapping("/departamento/{nombre}")
    public List<Empleado> obtenerPorDepartamento(@PathVariable String nombre) {
        return empleadoService.buscarPorDepartamento(nombre);
    }

    @GetMapping("/salario")
    public List<Empleado> obtenerPorRangoSalario(@RequestParam BigDecimal min,
                                                 @RequestParam BigDecimal max) {
        return empleadoService.buscarPorRangoSalario(min, max);
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
    }
}
