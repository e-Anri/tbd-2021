package cl.tbd.backendayni.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
public class Ranking {
    /**
     * ATRIBUTOS DE Ranking
     * 
     * @param id            del Ranking
     * @param porcentaje    del Ranking
     * @param id_tarea      del Ranking
     * @param id_voluntario del Ranking
     */
    @Id
    private String id;
    private long porcentaje;
    private String id_tarea;
    private String id_voluntario;
    private String id_estado;

    // CONSTRUCTOR Ranking
    public Ranking() {
    }

    // CONSTRUCTOR Ranking
    public Ranking(String id, long porcentaje, String id_tarea, String id_voluntario, String id_estado) {
        this.id = id;
        this.porcentaje = porcentaje;
        this.id_tarea = id_tarea;
        this.id_voluntario = id_voluntario;
        this.id_estado = id_estado;
    }

    // GETTERS Ranking

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @return porcentaje
     */
    public long getPorcentaje() {
        return porcentaje;
    }

    /**
     * @return id_tarea
     */
    public String getId_tarea() {
        return id_tarea;
    }

    /**
     * @return id_voluntario
     */
    public String getId_voluntario() {
        return id_voluntario;
    }

    /**
     * @return id_estado
     */
    public String getId_estado() {
        return id_estado;
    }

    // SETTERS Ranking

    /**
     * @param id del Ranking
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param porcentaje del Ranking
     */
    public void setPorcentaje(long porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @param id_tarea del Ranking
     */
    public void setId_tarea(String id_tarea) {
        this.id_tarea = id_tarea;
    }

    /**
     * @param id_voluntario del Ranking
     */
    public void setId_voluntario(String id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    /**
     * @param id_estado del Ranking
     */
    public void setId_estado(String id_estado) {
        this.id_estado = id_estado;
    }

    // TOSTRING Ranking

    /**
     * @return String con los datos del Ranking
     */
    @Override
    public String toString() {
        return "Ranking{" +
                "id='" + id + '\'' +
                ", porcentaje=" + porcentaje +
                ", id_tarea='" + id_tarea + '\'' +
                ", id_voluntario='" + id_voluntario + '\'' +
                ", id_estado='" + id_estado + '\'' +
                '}';
    }

}