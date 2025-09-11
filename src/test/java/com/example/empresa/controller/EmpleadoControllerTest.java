package com.example.empresa.controller;

import com.example.empresa.entity.Empleado;
import com.example.empresa.service.EmpleadoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = EmpleadoController.class)
@ActiveProfiles("test")
class EmpleadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpleadoService empleadoService;

    @Test
    void GET_obtenerTodos_devuelve200_yLista() throws Exception {
        Empleado e = new Empleado();
        e.setId(1L);
        e.setNombre("Juan");
        e.setApellido("Pérez");
        e.setEmail("juan@empresa.com");
        e.setFechaContratacion(LocalDate.now());
        e.setSalario(new BigDecimal("1234.56"));

        Mockito.when(empleadoService.obtenerTodos()).thenReturn(List.of(e));

        mockMvc.perform(get("/api/empleados"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].email").value("juan@empresa.com"));
    }

    @Test
    void POST_crear_devuelve201() throws Exception {
        Empleado e = new Empleado();
        e.setId(10L);
        e.setNombre("Ana");
        e.setApellido("García");
        e.setEmail("ana@empresa.com");
        e.setFechaContratacion(LocalDate.now());
        e.setSalario(new BigDecimal("5000"));

        Mockito.when(empleadoService.guardar(any(Empleado.class))).thenReturn(e);

        String json = """
        {
          "nombre": "Ana",
          "apellido": "García",
          "email": "ana@empresa.com",
          "fechaContratacion": "2025-01-01",
          "salario": 5000
        }
        """;

        mockMvc.perform(post("/api/empleados")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(10));
    }
}
