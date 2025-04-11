# Proyecto CRUD con Spring Boot

Este es un proyecto que permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre notas utilizando Spring Boot, JPA, MySQL y manejo de CORS.

## Requisitos

- **Java 17** o superior
- **Maven**
- **XAMPP** (para usar MySQL localmente)

## Pasos de Configuración

### 1. Clonación del Repositorio

Primero, clona el repositorio en tu máquina local utilizando Git.

### 2. Configuración de XAMPP y MySQL

1. Abre XAMPP y asegúrate de que Apache y MySQL estén ejecutándose.
2. Crea una base de datos llamada `crud` en MySQL.   
   Esto se puede hacer a través del cliente de MySQL en XAMPP o cualquier otro cliente SQL.
3. Verifica que MySQL esté en funcionamiento y la base de datos `crud` esté disponible.

### 3. Configuración del archivo de propiedades

En el archivo `application.properties`, se debe configurar la conexión a la base de datos MySQL. Asegúrate de que la URL, el nombre de usuario y la contraseña sean correctos según tu entorno de base de datos local.

### 4. Configuración de CORS

En el proyecto, se ha configurado CORS globalmente. Verifica que la clase que maneja la configuración de CORS esté presente y que se permitan solicitudes desde el frontend (con la URL correspondiente de tu aplicación).

### 5. Dependencias de Maven

El proyecto utiliza las siguientes dependencias clave:

- **Spring Boot Starter Web** para crear una API REST.
- **Spring Boot Starter Data JPA** para la interacción con la base de datos.
- **MySQL Connector** para conectar con MySQL.
- **Lombok** para simplificar el código.

Verifica que estas dependencias estén correctamente definidas en el archivo `pom.xml`.

### 6. Ejecutar el Proyecto

Una vez que hayas configurado todo, puedes ejecutar la aplicación utilizando Maven. El comando necesario para ejecutar la aplicación será:

```bash
mvn spring-boot:run
```
## Es posible que debas ejecutar este comando más de una vez debido a problemas temporales de construcción.

## 7. Acceso a la API

La API estará disponible en los siguientes endpoints:

- **GET** `/notes`: Obtiene todas las notas.
- **GET** `/notes/{id}`: Obtiene una nota por su ID.
- **POST** `/notes`: Crea una nueva nota.
- **PUT** `/notes/{id}`: Actualiza una nota existente.
- **DELETE** `/notes/{id}`: Elimina una nota.

## 8. Verificación de la Configuración

- Verifica que los **CORS** estén correctamente configurados para permitir que tu frontend realice solicitudes al backend.
- Asegúrate de que la base de datos MySQL esté correctamente conectada y configurada en el archivo de propiedades.
- Verifica que las rutas de la API estén funcionando correctamente en una herramienta de prueba de API como **Postman**.

## Estructura del Proyecto

La estructura del proyecto está organizada de la siguiente manera:

- **controllers**: Contiene las clases encargadas de manejar las solicitudes HTTP y la lógica de la API.
- **services**: Contiene la lógica de negocio para el manejo de las notas.
- **models**: Define las entidades (en este caso, `NoteModel`) y los objetos de respuesta.
- **exceptions**: Manejo de excepciones personalizadas para la validación de la API.
- **config**: Configuración adicional, como CORS.

## Problemas Comunes

- **CORS**: Si encuentras problemas de CORS, asegúrate de que la URL de tu frontend esté correctamente configurada en el archivo de configuración de CORS.
- **Base de Datos**: Verifica que la base de datos `crud` exista y que las credenciales de conexión sean correctas.
