-- Departamentos
INSERT INTO departamentos (nombre, descripcion) VALUES ('IT','Tecnología');
INSERT INTO departamentos (nombre, descripcion) VALUES ('HR','Recursos Humanos');

-- Empleados (asignados a un departamento por su FK departamento_id)
INSERT INTO empleados (nombre, apellido, email, fecha_contratacion, salario, departamento_id)
VALUES
('Ana','García','ana@empresa.com','2023-01-10', 850000.00, 1),
('Luis','Pérez','luis@empresa.com','2024-03-05', 720000.00, 1),
('Mara','Lopez','mara@empresa.com','2022-11-20', 680000.00, 2);

-- Proyectos
INSERT INTO proyectos (nombre, descripcion, fecha_inicio, fecha_fin)
VALUES
('Migración Cloud','Llevar servicios a la nube','2024-02-01', NULL),
('Web Corporativa','Nueva web pública','2024-05-15', NULL);

-- Relación ManyToMany empleado_proyecto
-- (ajustá IDs si hace falta, acá se asume que los autoincrementales empezaron en 1)
INSERT INTO empleado_proyecto (empleado_id, proyecto_id) VALUES (1,1);
INSERT INTO empleado_proyecto (empleado_id, proyecto_id) VALUES (1,2);
INSERT INTO empleado_proyecto (empleado_id, proyecto_id) VALUES (2,1);
