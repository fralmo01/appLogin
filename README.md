# AppLogin Demo

Este es un proyecto base Spring Boot.

## Estructura del Proyecto

Para mantener el código limpio y colaborativo, por favor sigue esta estructura al añadir nuevas funcionalidades:

### 1. Modelos de Datos (`/model`)
Aquí van las Clases que representan las tablas de tu Base de Datos.
*   Ejemplo: `User.java`, `Producto.java`.
*   Anotados con `@Entity`.

### 2. Repositorios (`/repository`)
Aquí van las interfaces que comunican con la Base de Datos.
*   Extienden de `JpaRepository`.
*   Ejemplo: `UserRepository.java`.

### 3. Servicios (`/service`)
Aquí va la **Lógica de Negocio**. Es el cerebro de la aplicación.
*   No pongas lógica compleja en los Controladores. Ponla aquí.
*   Ejemplo: `UserService.java`.

### 4. Controladores (`/controller`)
Aquí van las clases que reciben las peticiones Web (URLs).
*   Solo deben llamar a los Servicios y decidir qué Vista mostrar.
*   Ejemplo: `AuthController.java`.

### 5. DTOs (`/dto`)
(Opcional pero recomendado) Objetos simples para pasar datos.
*   Úsalos si el formulario tiene campos que no existen exactamente en la Base de Datos.

### 6. Configuración (`/config`)
Clases de configuración como Seguridad (`SecurityConfig`).

---

## Base de Datos (MySQL)

Para que el proyecto funcione, ejecuta este script en tu gestor de base de datos (MySQL Workbench, phpMyAdmin, etc.):

```sql
CREATE DATABASE IF NOT EXISTS BDuser;
USE BDuser;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreuser VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    edad INT,
    correo VARCHAR(150) NOT NULL UNIQUE
);
```

---

## Cómo Ejecutar
1.  Asegúrate de tener MySQL corriendo.
2.  Abre la terminal en la carpeta del proyecto.
3.  Ejecuta:
    ```bash
    .\mvnw spring-boot:run
    ```
