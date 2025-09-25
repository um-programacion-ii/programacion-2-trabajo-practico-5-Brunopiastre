# Prompts de Testing

## Prompt 1: Test unitario de EmpleadoService

### Prompt Utilizado:
"Generame un test unitario con JUnit5 y Mockito para probar EmpleadoService."

### Respuesta Recibida:
Se generó una clase `EmpleadoServiceTest` con mocks de `EmpleadoRepository` y pruebas básicas.

### Modificaciones Realizadas:
- Se agregaron asserts adicionales para validar atributos.
- Se probaron casos de error lanzando `EntityNotFoundException`.

### Explicación del Prompt:
Aseguró que la lógica de negocio funcione sin depender de la BD.

### Aprendizajes Obtenidos:
- Cómo usar Mockito para simular dependencias.
- Importancia de probar excepciones.

---

## Prompt 2: Test de integración con H2

### Prompt Utilizado:
"Generame un test de integración para EmpleadoService usando H2 como base de datos en memoria."

### Respuesta Recibida:
Se creó `EmpleadoServiceIntegrationTest` con `@SpringBootTest` y un perfil H2 configurado.

### Modificaciones Realizadas:
- Se agregaron datos de prueba en `data.sql`.
- Se validó que los métodos CRUD funcionen contra la BD real.

### Explicación del Prompt:
Probó la aplicación completa con una base de datos en memoria.

### Aprendizajes Obtenidos:
- Configuración de perfiles en Spring Boot.
- Uso de H2 para pruebas rápidas.

---

## Prompt 3: Test del controlador con MockMvc

### Prompt Utilizado:
"Generame un test para EmpleadoController usando MockMvc."

### Respuesta Recibida:
Se generó una clase `EmpleadoControllerTest` con `@AutoConfigureMockMvc` y `@SpringBootTest`.

### Modificaciones Realizadas:
- Se agregaron pruebas para `GET /empleados/salario`.
- Se probó validación de datos incorrectos (400 Bad Request).

### Explicación del Prompt:
Validó que los endpoints funcionen y devuelvan los códigos correctos.

### Aprendizajes Obtenidos:
- Uso de MockMvc para simular requests HTTP.
- Buenas prácticas de pruebas de controladores.
