package cl.tbd.backendayni.models;

import org.springframework.data.annotation.Id;

public class Emergencia_Habilidad {

    /**
     * ATRIBUTOS DE Emergencia_Habilidad
     * 
     * @param id            de la Emergencia_Habilidad
     * @param id_emergencia de la Emergencia_Habilidad
     * @param id_habilidad  de la Emergencia_Habilidad
     */
    @Id
    private String id;
    private String id_emergencia;
    private String id_habilidad;

    // CONSTRUCTOR Emergencia_Habilidad
    public Emergencia_Habilidad() {
    }

    // CONSTRUCTOR Emergencia_Habilidad
    public Emergencia_Habilidad(String id, String id_emergencia, String id_habilidad) {
        this.id = id;
        this.id_emergencia = id_emergencia;
        this.id_habilidad = id_habilidad;
    }

    // GETTERS Emergencia_Habilidad

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @return id_emergencia
     */
    public String getId_emergencia() {
        return id_emergencia;
    }

    /**
     * @return id_habilidad
     */
    public String getId_habilidad() {
        return id_habilidad;
    }

    // SETTERS Emergencia_Habilidad

    /**
     * @param id de la Emergencia_Habilidad
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param id_emergencia de la Emergencia_Habilidad
     */
    public void setId_emergencia(String id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    /**
     * @param id_habilidad de la Emergencia_Habilidad
     */
    public void setId_habilidad(String id_habilidad) {
        this.id_habilidad = id_habilidad;
    }

    // TOSTRING Emergencia_Habilidad

    /**
     * @return String con los datos de la Emergencia_Habilidad
     */
    @Override
    public String toString() {
        return "Emergencia_Habilidad{" +
                "id=" + id +
                ", id_emergencia=" + id_emergencia +
                ", id_habilidad=" + id_habilidad +
                '}';
    }

}
