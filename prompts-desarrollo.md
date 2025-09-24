# Prompts de Desarrollo

## Prompt 1: Creación de la entidad Empleado

### Prompt Utilizado:
"Generame la entidad JPA para Empleado con atributos nombre, apellido, email, salario, fechaContratacion y relación con Departamento."

### Respuesta Recibida:
Se generó una clase `Empleado` con anotaciones `@Entity`, `@Id`, `@GeneratedValue`, y relación `@ManyToOne` con `Departamento`.

### Modificaciones Realizadas:
- Se cambió el tipo de salario a `BigDecimal` para precisión.
- Se agregó validación `@Email` al campo `email`.
- Se añadió `@JsonIgnoreProperties` en las relaciones para evitar ciclos infinitos en JSON.

### Explicación del Prompt:
Permitió generar rápidamente la base de la entidad sin escribir todo a mano.

### Aprendizajes Obtenidos:
- Validaciones con `jakarta.validation`.
- Importancia de mapear bien relaciones en JPA.

---

## Prompt 2: Implementación de Repositorio y Servicio

### Prompt Utilizado:
"Generame un JpaRepository para Empleado y un Service con métodos CRUD."

### Respuesta Recibida:
Se creó `EmpleadoRepository` extendiendo `JpaRepository<Empleado, Long>` y un `EmpleadoService` con métodos `guardar`, `buscarPorId`, `listarTodos`, `eliminar`.

### Modificaciones Realizadas:
- Se agregó método `findBySalarioBetween` al repositorio.
- En el service se agregó manejo de excepciones al buscar un empleado inexistente.

### Explicación del Prompt:
Ayudó a implementar la capa de acceso a datos y lógica de negocio de forma ordenada.

### Aprendizajes Obtenidos:
- Cómo extender `JpaRepository` para queries personalizadas.
- Uso de `Optional` en búsquedas.

---

## Prompt 3: Creación del EmpleadoController

### Prompt Utilizado:
"Generame un controlador REST para Empleado con endpoints CRUD y búsqueda por rango de salario."

### Respuesta Recibida:
Un `EmpleadoController` con endpoints `@PostMapping`, `@GetMapping`, `@PutMapping`, `@DeleteMapping`.

### Modificaciones Realizadas:
- Se agregó endpoint `GET /empleados/departamento/{nombre}`.
- Se integró `EmpleadoService` con inyección `@Autowired`.
- Se incluyó validación de datos en el body con `@Valid`.

### Explicación del Prompt:
Permitió construir la API REST de forma estándar.

### Aprendizajes Obtenidos:
- Cómo mapear endpoints REST en Spring Boot.
- Validaciones automáticas en controladores.

---

## Prompt 4: Manejo de excepciones global

### Prompt Utilizado:
"Generame un GlobalExceptionHandler para manejar EntityNotFoundException."

### Respuesta Recibida:
Clase `GlobalExceptionHandler` con `@ControllerAdvice` y `@ExceptionHandler`.

### Modificaciones Realizadas:
- Se agregó un DTO de error con timestamp, mensaje y detalle.
- Se adaptó para manejar también `IllegalArgumentException`.

### Explicación del Prompt:
Se utilizó para centralizar el manejo de errores en la API.

### Aprendizajes Obtenidos:
- Uso de `@ControllerAdvice` en Spring.
- Buenas prácticas para respuestas de error.
