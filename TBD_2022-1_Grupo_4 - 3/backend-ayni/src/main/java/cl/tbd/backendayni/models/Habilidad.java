package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
public class Habilidad {
    /**
     * ATRIBUTOS DE Habilidad
     * 
     * @param id     de la habilidad
     * @param nombre de la habilidad
     */
    @Id
    private String id;
    private String nombre;

    // CONSTRUCTOR Habilidad
    public Habilidad() {
    }

    // CONSTRUCTOR Habilidad
    public Habilidad(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // GETTERS Habilidad

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    // SETTERS Habilidad

    /**
     * @param id de la habilidad
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param nombre de la habilidad
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // TOSTRING Habilidad

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Habilidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

}
