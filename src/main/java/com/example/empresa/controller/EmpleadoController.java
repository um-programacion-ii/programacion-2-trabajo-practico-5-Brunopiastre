package com.example.empresa.controller;

import com.example.empresa.entity.Empleado;
import com.example.empresa.service.EmpleadoService;
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
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Long id){ service.delete(id); }

    // Asignar empleado a proyecto (ManyToMany)
    @PostMapping("/{empleadoId}/proyectos/{proyectoId}")
    public Empleado asignarProyecto(@PathVariable Long empleadoId, @PathVariable Long proyectoId){
        return service.asignarProyecto(empleadoId, proyectoId);
    }
}
