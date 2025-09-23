package com.example.empresa.entity;
<<<<<<< HEAD

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
=======
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
=======
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)

import jakarta.persistence.*;
>>>>>>> origin/main
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
<<<<<<< HEAD
@Table(name = "proyectos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto {
=======
<<<<<<< HEAD
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "proyectos")
public class Proyecto {

>>>>>>> origin/main
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 1000)
    private String descripcion;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @ManyToMany(mappedBy = "proyectos")
    @JsonIgnore // 👈 evita recursión y ConcurrentModificationException
    private Set<Empleado> empleados = new HashSet<>();
=======
    private String nombre;

    // Campos que te pide el service
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ManyToMany(mappedBy = "proyectos")
    private Set<Empleado> empleados = new HashSet<>();

    // --- Getters/Setters necesarios ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

=======
@Table(name="proyectos")
public class Proyecto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String nombre;

    @Column(length=1000)
    private String descripcion;

    @Column(name="fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name="fecha_fin")
    private LocalDate fechaFin;

    @ManyToMany(mappedBy="proyectos")
    private Set<Empleado> empleados = new HashSet<>();

    // Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
    public Set<Empleado> getEmpleados() { return empleados; }
    public void setEmpleados(Set<Empleado> empleados) { this.empleados = empleados; }
>>>>>>> origin/main
}
