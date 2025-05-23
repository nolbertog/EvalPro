# EvalPro

**EvalPro** es una aplicación web desarrollada en Java con Spring Boot para la gestión de usuarios y autenticación segura mediante JWT. Incluye endpoints protegidos y públicos, y un flujo de login moderno pensado para integrarse fácilmente con frontends web o móviles.

## Características

- Registro y gestión de usuarios
- Autenticación segura con JWT (JSON Web Token)
- Endpoints protegidos y públicos
- Ejemplo de consumo desde HTML/JavaScript
- Configuración de seguridad personalizable con Spring Security

## Tecnologías utilizadas

- Java 21+
- Spring Boot
- Spring Security
- JWT (JJWT)
- Gradle
- PostgreSQL (ajusta según tu base de datos)

## Instalación y ejecución

1. **Clona el repositorio:**
   ```sh
   git clone https://github.com/nolbertog/EvalPro.git
   cd EvalPro
Configura tu base de datos en src/main/resources/application.properties si es necesario.
Compila y ejecuta la aplicación:
sh
Copy Code
./gradlew bootRun
Accede a la API en http://localhost:8080
Endpoints principales
POST /api/login
Autenticación de usuario. Devuelve un JWT si las credenciales son correctas.
GET /api/usuarios
Devuelve la lista de usuarios (requiere JWT en el header Authorization).
Ejemplo de login desde HTML
html
Copy Code
<!-- Ver el archivo login.html en este repositorio para un ejemplo completo -->
<form id="loginForm">
  <input type="email" id="email" required>
  <input type="password" id="password" required>
  <button type="submit">Iniciar sesión</button>
</form>
<script>
  // Ver ejemplo completo en el repositorio
</script>
Uso del token JWT
Después de hacer login, el backend devuelve un token.
En cada petición protegida, envía el token en el header:

Authorization: Bearer <tu_token>
Contribuciones
¡Las contribuciones son bienvenidas!
Abre un issue o un pull request para sugerencias, mejoras o reportar bugs.

Licencia
Este proyecto está bajo la licencia MIT.

EvalPro © 2024 - nolbertog


---
