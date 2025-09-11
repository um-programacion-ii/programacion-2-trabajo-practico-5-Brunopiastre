package com.example.empresa.controller;

import com.example.empresa.entity.Departamento;
import com.example.empresa.service.DepartamentoService;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
=======
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/departamentos")
public class DepartamentoController {
    private final DepartamentoService service;
    public DepartamentoController(DepartamentoService service){ this.service = service; }

    @GetMapping public List<Departamento> listar(){ return service.findAll(); }
    @GetMapping("/{id}") public Departamento obtener(@PathVariable Long id){ return service.findById(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public Departamento crear(@RequestBody Departamento d){ return service.save(d); }
    @PutMapping("/{id}") public Departamento actualizar(@PathVariable Long id, @RequestBody Departamento d){ return service.update(id,d); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Long id){ service.delete(id); }
=======
@RequestMapping("/api/departamentos")
@Validated
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public List<Departamento> obtenerTodos() {
        return departamentoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Departamento obtenerPorId(@PathVariable Long id) {
        return departamentoService.buscarPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public Departamento obtenerPorNombre(@PathVariable String nombre) {
        return departamentoService.buscarPorNombre(nombre);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Departamento crear(@Valid @RequestBody Departamento dpto) {
        return departamentoService.guardar(dpto);
    }

    @PutMapping("/{id}")
    public Departamento actualizar(@PathVariable Long id, @Valid @RequestBody Departamento dpto) {
        return departamentoService.actualizar(id, dpto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        departamentoService.eliminar(id);
    }
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
}
