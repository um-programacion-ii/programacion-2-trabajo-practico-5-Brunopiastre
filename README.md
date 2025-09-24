# Trabajo Práctico 5 - Programación II

## 🚀 Instalación y Ejecución

### 1. Clonar el repositorio
```bash
git clone <URL_DEL_REPO>
cd programacion-2-trabajo-practico-5-Brunopiastre
```

### 2. Levantar bases de datos con Docker
```bash
docker compose up -d
```

### 3. Ejecutar con perfil de desarrollo (H2)
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

### 4. Ejecutar con perfil MySQL
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql
```

### 5. Ejecutar con perfil PostgreSQL
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=postgres
```

## 🧪 Testing
```bash
./mvnw clean test
```

## 📌 Autor
- Bruno Piastrellini - Legajo: 62083

## 📋 Documentación de Prompts
Este proyecto incluye documentación adicional requerida en la entrega:

- [prompts-desarrollo.md](prompts-desarrollo.md)
- [prompts-testing.md](prompts-testing.md)
- [prompts-docker.md](prompts-docker.md)
- [prompts-documentacion.md](prompts-documentacion.md)
