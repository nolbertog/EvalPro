-- Tabla de usuarios (profesores)
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL -- Recuerda almacenar el hash, no la contraseña en texto plano
);

-- Tabla de alumnos
CREATE TABLE alumnos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    anio INTEGER NOT NULL,
    nivel VARCHAR(255) NOT NULL,
    usuario_id INTEGER NOT NULL REFERENCES usuarios(id) -- El profesor responsable
);

-- Tabla de criterios de evaluación
CREATE TABLE criterios (
    id SERIAL PRIMARY KEY,
    descripcion TEXT NOT NULL,
    usuario_id INTEGER NOT NULL REFERENCES usuarios(id) -- El profesor que creó el criterio
);

-- Tabla de evaluaciones
CREATE TABLE evaluaciones (
    id SERIAL PRIMARY KEY,
    alumno_id INTEGER NOT NULL REFERENCES alumnos(id) ON DELETE CASCADE,
    criterio_id INTEGER NOT NULL REFERENCES criterios(id) ON DELETE CASCADE,
    estado VARCHAR(20) NOT NULL CHECK (estado IN ('Logrado', 'No Logrado', 'No Calificado')),
    fecha DATE NOT NULL DEFAULT CURRENT_DATE,
    UNIQUE (alumno_id, criterio_id, fecha) -- Un alumno solo puede tener una evaluación por criterio y fecha
);

-- Índices sugeridos para mejorar el rendimiento de las búsquedas
CREATE INDEX idx_alumnos_usuario ON alumnos(usuario_id);
CREATE INDEX idx_criterios_usuario ON criterios(usuario_id);
CREATE INDEX idx_evaluaciones_alumno ON evaluaciones(alumno_id);
CREATE INDEX idx_evaluaciones_criterio ON evaluaciones(criterio_id);