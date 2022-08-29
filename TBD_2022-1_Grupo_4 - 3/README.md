# TBD_2022-1_Grupo_4

Laboratorio numero 3 de Taller de Base de Datos 2022-1

# LABORATORIO 3 - AYNI

# Integrantes 

```
- Estefanía Álvarez
- Felipe Cornejo 
- Bastian Loyola
- Bastian Onetto
- Carla Polanco
- Carlos Retamales
- Pablo Villarreal
```

La estructura del codigo se presenta de la siguiente manera:
```
---------------------------------------------------------------------------------------------------------------
TBD_2022-1_Grupo_4 -> - backend-ayni ->  - src/main/java/cl/tbd/backendayni ->  - models 
                                         - gradlew                              - repositories
                                                                                - BackendAyniApplication.java
                                         - src/main/python    -> - insertar_datos_region.py                                                           
                                         - src/main/resources -> - application.properties                  -
                      - frontend-ayni -> - assets 
                                         - components
                                         - pages 
                                         - static
                                         - store 
                                         - BACKEND_URL.env
                                         - nuxt.config.js
---------------------------------------------------------------------------------------------------------------
```

# INSTRUCCIONES DE USO

  - Descargar el repositorio en su formato zip y descomprimirlo en una carpeta destino (ejemplo escritorio) o clonar usando "git clone https://github.com/bastianloyola/TBD_2022-1_Grupo_4" en la carpeta destino (ejemplo escritorio).
  - Antes de Comenzar a levantar el proyecto, se debe tener en cuenta que se necesita tener MongoDB configurado en una conexion local en un puerto a eleccion.
  - Abrir una terminal (a preferencia del usuario) y dirigirse a la carpeta del proyecto (ejemplo: escritorio/TBD_2022-1_Grupo_4).
  - Ya teniendo todos los requisitos para ejecutar el proyecto (*), y estando en la terminal en la carpeta destino, realizamos el levantamiento del backend, en la terminal ingresamos "cd backend-ayni" y enter.
  - Luego de estar dentro backend-ayni debemos levantar la parte del backend del proyecto, de esta manera, ingresando "gradlew bootRun" (en caso de tener una terminal que tenga comandos de linux o powershell de windows, puede ingresar con "./gradlew bootRun"), esto levantara el apartado de backend en el puerto 3000 en localhost (http://localhost:3000).
  - En caso de que el mensaje de exito no se genere o no se visualize una base de datos llamada "test" en su GUI de conveniencia, debera comprobar su conexion de mongodb. Una vez arreglado, se guardan los cambios y se vuelve a levantar.
  - Ya levantado el apartado del backend en el puerto 3000 (http://localhost:3000), en una segunda parte en otra terminal, en la terminal 2, estando en la carpeta destino del proyecto ingresamos "cd frontend-ayni" y enter.
  - Luego de estar dentro frontend-ayni debemos levantar la parte del frontend del proyecto, debido a que la implementacion no esta completa puede generar errores, de esta manera, ingresando "npm install" se instalaran las dependencias necesarias para correr el proyecto, luego de que las dependencias se instalen, se ingresa "npm run dev" esto levantara el frontend en el puerto 8080 en el localhost(http://localhost:8080), en caso de errores de que falte un modulo, por ejemplo: "axios", debera correr "npm install nombre_modulo", en este caso, "npm install axios".
  - Ya realizando estos pasos podra interactuar con la aplicacion web de Ayni en el la pagina http://localhost:8080.
  - (*): npm, java 11+, gradle 5+, node js, vue, nuxt, mongodb.
