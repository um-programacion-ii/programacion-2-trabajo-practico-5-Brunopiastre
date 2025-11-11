# Prompts de Docker

## Prompt 1: Configuración inicial con Docker Compose

### Prompt Utilizado:
"Generame un docker-compose.yml con MySQL y PostgreSQL listos para usar en Spring Boot."

### Respuesta Recibida:
Archivo `docker-compose.yml` con servicios `empleados_mysql` y `empleados_postgres` con volúmenes y variables de entorno.

### Modificaciones Realizadas:
- Se agregó `healthcheck` para esperar que los contenedores estén listos.
- Se asignaron volúmenes persistentes.

### Explicación del Prompt:
Sirvió para tener entornos reproducibles en el TP.

### Aprendizajes Obtenidos:
- Diferencias de configuración entre MySQL y PostgreSQL.
- Cómo mapear puertos en Docker.

---

## Prompt 2: Resolver error de conexión con MySQL

### Prompt Utilizado:
"Cómo solucionar el error Communications link failure en MySQL."

### Respuesta Recibida:
Se indicó agregar `allowPublicKeyRetrieval=true` y `serverTimezone=UTC` a la URL JDBC.

### Modificaciones Realizadas:
- Se actualizó `application.yml` en el perfil `mysql`.

### Explicación del Prompt:
El prompt resolvió un error real al conectar la app con el contenedor MySQL.

### Aprendizajes Obtenidos:
- Importancia de los parámetros de conexión.
- Manejo de errores comunes con JDBC.

---

## Prompt 3: Optimización de configuración

### Prompt Utilizado:
"Qué buenas prácticas seguir para Dockerizar bases de datos en proyectos Spring Boot."

### Respuesta Recibida:
Consejos sobre usar volúmenes, no exponer contraseñas, y definir usuarios propios.

### Modificaciones Realizadas:
- Se creó usuario específico `empleados_user` en lugar de root.
- Se movieron credenciales a `application.yml`.

### Explicación del Prompt:
Permitió aplicar buenas prácticas de DevOps al proyecto.

### Aprendizajes Obtenidos:
- Seguridad en contenedores.
- Separación de entornos (dev/test/prod).
