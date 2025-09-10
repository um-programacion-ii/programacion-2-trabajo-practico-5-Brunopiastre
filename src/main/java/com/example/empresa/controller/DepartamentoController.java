package com.example.empresa.controller;

import com.example.empresa.entity.Departamento;
import com.example.empresa.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
}
