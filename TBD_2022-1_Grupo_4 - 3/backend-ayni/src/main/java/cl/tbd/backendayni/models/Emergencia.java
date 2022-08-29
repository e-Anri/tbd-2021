package cl.tbd.backendayni.models;

import java.sql.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@EntityScan
public class Emergencia {
    /**
     * ATRIBUTOS DE Emergencia
     * 
     * @param id                de la emergencia
     * @param nombre            de la emergencia
     * @param descripcion       de la emergencia
     * @param fecha             de la emergencia
     * @param reqs_grupales     de la emergencia
     * @param reqs_individuales de la emergencia
     * @param longitude         de la emergencia
     * @param latitude          de la emergencia
     * @param geom              de la emergencia
     */
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private String reqs_grupales;
    private String reqs_individuales;
    private double longitude;
    private double latitude;
    private String geom;

    // CONSTRUCTOR Emergencia
    public Emergencia() {
    }

    // CONSTRUCTOR Emergencia
    public Emergencia(String id, String nombre, String descripcion, Date fecha, String reqs_grupales,
            String reqs_individuales, double longitude, double latitude, String geom) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.reqs_grupales = reqs_grupales;
        this.reqs_individuales = reqs_individuales;
        this.longitude = longitude;
        this.latitude = latitude;
        this.geom = geom;
    }

    // GETTERS Emergencia

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

    /**
     * @return descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @return reqs_grupales
     */
    public String getReqs_grupales() {
        return reqs_grupales;
    }

    /**
     * @return reqs_individuales
     */
    public String getReqs_individuales() {
        return reqs_individuales;
    }

    /**
     * @return longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @return latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @return geom
     */
    public String getGeom() {
        return geom;
    }

    // SETTERS Emergencia

    /**
     * @param id id a setear
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param nombre nombre a setear
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param descripcion descripcion a setear
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @param fecha fecha a setear
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @param reqs_grupales reqs_grupales a setear
     */
    public void setReqs_grupales(String reqs_grupales) {
        this.reqs_grupales = reqs_grupales;
    }

    /**
     * @param reqs_individuales reqs_individuales a setear
     */
    public void setReqs_individuales(String reqs_individuales) {
        this.reqs_individuales = reqs_individuales;
    }

    /**
     * @param longitude longitude a setear
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * @param latitude latitude a setear
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * @param geom geom a setear
     */
    public void setGeom(String geom) {
        this.geom = geom;
    }

    // TOSTRING Emergencia

    /**
     * @return String de la emergencia
     */
    @Override
    public String toString() {
        return "Emergencia [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecha=" + fecha
                + ", reqs_grupales=" + reqs_grupales + ", reqs_individuales=" + reqs_individuales + ", longitude="
                + longitude + ", latitude=" + latitude + ", geom=" + geom + "]";
    }

}
