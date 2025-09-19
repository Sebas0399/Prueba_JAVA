///////////////////////////AUTH///////////////////////////////


| Método | Endpoint        | Descripción                       | Request Body                          | Response                  |
|--------|----------------|-----------------------------------|--------------------------------------|--------------------------|
| POST   | `/usuarios/register` | Registrar un nuevo usuario        | JSON con `nombre`, `email`, `password` | JSON con datos del usuario creado o mensaje de error |
| POST   | `/auth/authenticate` | Iniciar sesión / obtener JWT     | JSON con `email` y `password`     | JSON con token JWT (`accessToken`) |

///////////////////////////TAREAS///////////////////////////
| Método | Endpoint                   | Descripción                            | Request Body / Parámetros              |
| ------ | -------------------------- | -------------------------------------- | -------------------------------------- |
| POST   | `/tareas`                  | Crear una tarea para el usuario actual | JSON con `titulo`, `descripcion`, etc. |
| GET    | `/tareas/{id}`             | Obtener una tarea específica           | `id` de la tarea (path variable)       |
| PUT    | `/tareas/{id}`             | Editar una tarea                       | JSON con campos a actualizar           |
| DELETE | `/tareas/{id}`             | Eliminar una tarea                     | `id` de la tarea (path variable)       |
| GET    | `/tareas/usuario/{userId}` | Listar todas las tareas de un usuario  | `userId` (path variable)               |

# Prueba_JAVA

# Limpiar y compilar el proyecto
./mvnw clean install

# Ejecutar pruebas unitarias e integración
./mvnw test

#levantar el docker
docker-compose -f docker-compose.yml up --build
