package cl.tbd.backendayni.models;

import java.sql.Date;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Tarea {
	// ATRIBUTOS DE TAREA
	/**
	 * @param id             de la tarea
	 * @param id_emergencia  de la tarea
	 * @param nombre         de la tarea
	 * @param descripcion    de la tarea
	 * @param fecha          de la tarea
	 * @param requerimientos de la tarea
	 * @param longitude      de la tarea
	 * @param latitude       de la tarea
	 * @param geom           de la tarea
	 */

	private long id;
	private long id_emergencia;
	private String nombre;
	private String descripcion;
	private Date fecha;
	private String requerimientos;
	private double longitude;
	private double latitude;
	private String geom;

	// CONSTRUCTOR TAREA
	public Tarea() {
	}

	// Constructor de la clase Tarea
	public Tarea(long id, long id_emergencia, String nombre, String descripcion, Date fecha, String requerimientos,
			double longitude, double latitude, String geom) {
		this.id = id;
		this.id_emergencia = id_emergencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.requerimientos = requerimientos;
		this.longitude = longitude;
		this.latitude = latitude;
		this.geom = geom;
	}

	// GETTERS TAREA

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return id_emergencia
	 */
	public long getId_emergencia() {
		return id_emergencia;
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
	 * @return requerimientos
	 */
	public String getRequerimientos() {
		return requerimientos;
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

	// SETTERS TAREA

	/**
	 * @param id de la tarea
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param id_emergencia de la tarea
	 */
	public void setId_emergencia(long id_emergencia) {
		this.id_emergencia = id_emergencia;
	}

	/**
	 * @param nombre de la tarea
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param descripcion de la tarea
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @param fecha de la tarea
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @param requerimientos de la tarea
	 */
	public void setRequerimientos(String requerimientos) {
		this.requerimientos = requerimientos;
	}

	/**
	 * @param longitude de la tarea
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param latitude de la tarea
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @param geom de la tarea
	 */
	public void setGeom(String geom) {
		this.geom = geom;
	}

	// TOSTRING TAREA
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", id_emergencia=" + id_emergencia + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", fecha=" + fecha + ", requerimientos=" + requerimientos + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}

}