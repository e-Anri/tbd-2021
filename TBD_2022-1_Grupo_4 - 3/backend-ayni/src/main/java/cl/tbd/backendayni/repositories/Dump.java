package cl.tbd.backendayni.repositories;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import cl.tbd.backendayni.models.Tarea;
import cl.tbd.backendayni.models.Voluntario;

public class Dump {
    @Autowired
    private TareaRepository repositoryTarea;
    @Autowired
    private VoluntarioRepository repositoryVoluntario;

    // constructor
    public Dump() {
    }

    // constructor
    public Dump(TareaRepository repositoryTarea, VoluntarioRepository repositoryVoluntario) {
        this.repositoryTarea = repositoryTarea;
        this.repositoryVoluntario = repositoryVoluntario;
    }

    // getters
    public TareaRepository getRepositoryTarea() {
        return repositoryTarea;
    }

    public VoluntarioRepository getRepositoryVoluntario() {
        return repositoryVoluntario;
    }

    public void crearTablas() {
        // crear tabla tareas
        repositoryTarea.deleteAll();
        // get today date as string
        String today = new Date().toString();
        repositoryTarea.save(new Tarea("Tarea 1", "Descripcion 1", "Estado 1", null, "Voluntario 1", "Voluntario 2",
                "Voluntario 3"));
        repositoryTarea.save(new Tarea("Tarea 2", "Descripcion 2", "Estado 2", null, "Voluntario 1", "Voluntario 2",
                "Voluntario 3"));
        repositoryTarea.save(new Tarea("Tarea 3", "Descripcion 3", "Estado 3", null, "Voluntario 1", "Voluntario 2",
                "Voluntario 3"));
        repositoryTarea.save(new Tarea("Tarea 4", "Descripcion 4", "Estado 4", null, "Voluntario 1", "Voluntario 2",
                "Voluntario 3"));
        repositoryTarea.save(new Tarea("Tarea 5", "Descripcion 5", "Estado 5", null, "Voluntario 1", "Voluntario 2",
                "Voluntario 3"));

        // crear tabla voluntarios
        repositoryVoluntario.deleteAll();
        repositoryVoluntario.save(new Voluntario("correo1", "usuario1", "nombre1", "password1", "atributos1"));
        repositoryVoluntario.save(new Voluntario("correo2", "usuario2", "nombre2", "password2", "atributos2"));
        repositoryVoluntario.save(new Voluntario("correo3", "usuario3", "nombre3", "password3", "atributos3"));
        repositoryVoluntario.save(new Voluntario("correo4", "usuario4", "nombre4", "password4", "atributos4"));
        repositoryVoluntario.save(new Voluntario("correo5", "usuario5", "nombre5", "password5", "atributos5"));
        repositoryVoluntario.save(new Voluntario("correo6", "usuario6", "nombre6", "password6", "atributos6"));
    }

}
