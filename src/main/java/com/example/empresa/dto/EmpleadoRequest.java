package com.example.empresa.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
public class EmpleadoRequest {
    private String nombre;
    private String apellido;
    private String email;
    private LocalDate fechaContratacion;
    private BigDecimal salario;
    private Long departamentoId;
    private Set<Long> proyectos; // IDs de proyectos asociados
}
