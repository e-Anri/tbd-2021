package cl.tbd.backendayni.models;

import org.springframework.data.annotation.Id;

public class Voluntario_Habilidad {

    /**
     * ATRIBUTOS DE Voluntario_Habilidad
     * 
     * @param id            de la Voluntario_Habilidad
     * @param id_voluntario de la Voluntario_Habilidad
     * @param id_habilidad  de la Voluntario_Habilidad
     */
    @Id
    private String id;
    private String id_voluntario;
    private String id_habilidad;

    // CONSTRUCTOR Voluntario_Habilidad
    public Voluntario_Habilidad() {
    }

    // CONSTRUCTOR Voluntario_Habilidad
    public Voluntario_Habilidad(String id, String id_voluntario, String id_habilidad) {
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.id_habilidad = id_habilidad;
    }

    // GETTERS Voluntario_Habilidad

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @return id_voluntario
     */
    public String getId_voluntario() {
        return id_voluntario;
    }

    /**
     * @return id_habilidad
     */
    public String getId_habilidad() {
        return id_habilidad;
    }

    // SETTERS Voluntario_Habilidad

    /**
     * @param id de la Voluntario_Habilidad
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param id_voluntario de la Voluntario_Habilidad
     */
    public void setId_voluntario(String id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    /**
     * @param id_habilidad de la Voluntario_Habilidad
     */
    public void setId_habilidad(String id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    // TOSTRING Voluntario_Habilidad

    /**
     * @return String con los atributos de la Voluntario_Habilidad
     */
    @Override
    public String toString() {
        return "Voluntario_Habilidad{" +
                "id=" + id +
                ", id_voluntario=" + id_voluntario +
                ", id_habilidad=" + id_habilidad +
                '}';
    }

}
