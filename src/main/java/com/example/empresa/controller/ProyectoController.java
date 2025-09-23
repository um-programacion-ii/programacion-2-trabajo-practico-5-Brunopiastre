package com.example.empresa.controller;

import com.example.empresa.entity.Proyecto;
import com.example.empresa.service.ProyectoService;
<<<<<<< HEAD
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
=======
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
=======
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
>>>>>>> origin/main
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/api/proyectos")
=======
<<<<<<< HEAD
@RequestMapping("/proyectos")
public class ProyectoController {
    private final ProyectoService service;
    public ProyectoController(ProyectoService service){ this.service = service; }

    @GetMapping public List<Proyecto> listar(){ return service.findAll(); }
    @GetMapping("/{id}") public Proyecto obtener(@PathVariable Long id){ return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Proyecto crear(@RequestBody Proyecto p){ return service.save(p); }
    @PutMapping("/{id}") public Proyecto actualizar(@PathVariable Long id, @RequestBody Proyecto p){ return service.update(id,p); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Long id){ service.delete(id); }
=======
@RequestMapping("/api/proyectos")
@Validated
>>>>>>> origin/main
public class ProyectoController {

    private final ProyectoService proyectoService;

    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    @GetMapping
    public List<Proyecto> obtenerTodos() {
        return proyectoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Proyecto obtenerPorId(@PathVariable Long id) {
        return proyectoService.buscarPorId(id);
    }

<<<<<<< HEAD
=======
    @GetMapping("/activos")
    public List<Proyecto> obtenerActivos() {
        return proyectoService.buscarActivos();
    }

>>>>>>> origin/main
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proyecto crear(@Valid @RequestBody Proyecto proyecto) {
        return proyectoService.guardar(proyecto);
    }

    @PutMapping("/{id}")
    public Proyecto actualizar(@PathVariable Long id, @Valid @RequestBody Proyecto proyecto) {
        return proyectoService.actualizar(id, proyecto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        proyectoService.eliminar(id);
    }
<<<<<<< HEAD
=======
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
>>>>>>> origin/main
}
