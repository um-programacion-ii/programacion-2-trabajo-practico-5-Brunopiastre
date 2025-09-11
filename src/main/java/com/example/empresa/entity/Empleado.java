package com.example.empresa.entity;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.*;
=======

import jakarta.persistence.*;
import java.math.BigDecimal;
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
<<<<<<< HEAD
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private Double salario;

    // Campo que te pide el service
    private LocalDate fechaContratacion;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    // Relación que te pide el service (getProyectos)
    @ManyToMany
    @JoinTable(
            name = "empleado_proyecto",
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "proyecto_id")
    )
    private Set<Proyecto> proyectos = new HashSet<>();

    // --- Getters/Setters necesarios ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }

    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }

=======
@Table(name = "empleados")
public class Empleado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, length=100)
    private String nombre;

    @Column(nullable=false, length=100)
    private String apellido;

    @Column(unique=true, nullable=false)
    private String email;

    @Column(name="fecha_contratacion", nullable=false)
    private LocalDate fechaContratacion;

    @Column(nullable=false, precision=10, scale=2)
    private BigDecimal salario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="departamento_id")
    private Departamento departamento;

    @ManyToMany
    @JoinTable(
        name = "empleado_proyecto",
        joinColumns = @JoinColumn(name = "empleado_id"),
        inverseJoinColumns = @JoinColumn(name = "proyecto_id")
    )
    private Set<Proyecto> proyectos = new HashSet<>();

    // Getters/Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(LocalDate fechaContratacion) { this.fechaContratacion = fechaContratacion; }
    public BigDecimal getSalario() { return salario; }
    public void setSalario(BigDecimal salario) { this.salario = salario; }
    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
>>>>>>> be1df26 (fix: corregida clase main y nombres de controllers para compilar correctamente)
    public Set<Proyecto> getProyectos() { return proyectos; }
    public void setProyectos(Set<Proyecto> proyectos) { this.proyectos = proyectos; }
}
