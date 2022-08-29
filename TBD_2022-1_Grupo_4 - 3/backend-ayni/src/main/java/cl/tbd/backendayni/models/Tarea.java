package cl.tbd.backendayni.models;

import java.sql.Date;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

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
	@Id
	private String id;
	private String id_emergencia;
	private String nombre;
	private String descripcion;
	private String fecha;
	private String requerimientos;
	private String longitude;
	private String latitude;

	// CONSTRUCTOR TAREA
	public Tarea() {
	}

	// Constructor de la clase Tarea
	public Tarea(String id_emergencia, String nombre, String descripcion, String fecha, String requerimientos,
			String longitude, String latitude) {
		this.id_emergencia = id_emergencia;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.requerimientos = requerimientos;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	// GETTERS TAREA

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
	public String getFecha() {
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
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @return latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	// SETTERS TAREA

	/**
	 * @param id de la tarea
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param id_emergencia de la tarea
	 */
	public void setId_emergencia(String id_emergencia) {
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
	public void setFecha(String fecha) {
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
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @param latitude de la tarea
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	// TOSTRING TAREA
	@Override
	public String toString() {
		return "Tarea [id=" + id + ", id_emergencia=" + id_emergencia + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", fecha=" + fecha + ", requerimientos=" + requerimientos + ", longitude=" + longitude
				+ ", latitude=" + latitude + "]";
	}

}