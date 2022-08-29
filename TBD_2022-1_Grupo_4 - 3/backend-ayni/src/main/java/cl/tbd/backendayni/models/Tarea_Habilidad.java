package cl.tbd.backendayni.models;

import org.springframework.data.annotation.Id;

public class Tarea_Habilidad {

	/**
	 * ATRIBUTOS DE Tarea_Habilidad
	 * 
	 * @param id           de la Tarea_Habilidad
	 * @param id_tarea     de la Tarea_Habilidad
	 * @param id_habilidad de la Tarea_Habilidad
	 */
	@Id
	private String id;
	private String id_tarea;
	private String id_habilidad;

	// CONSTRUCTOR Tarea_Habilidad
	public Tarea_Habilidad() {
	}

	// CONSTRUCTOR Tarea_Habilidad
	public Tarea_Habilidad(String id, String id_tarea, String id_habilidad) {
		this.id = id;
		this.id_tarea = id_tarea;
		this.id_habilidad = id_habilidad;
	}

	// GETTERS Tarea_Habilidad

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return id_tarea
	 */
	public String getId_tarea() {
		return id_tarea;
	}

	/**
	 * @return id_habilidad
	 */
	public String getId_habilidad() {
		return id_habilidad;
	}

	// SETTERS Tarea_Habilidad

	/**
	 * @param id de la Tarea_Habilidad
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param id_tarea de la Tarea_Habilidad
	 */
	public void setId_tarea(String id_tarea) {
		this.id_tarea = id_tarea;
	}

	/**
	 * @param id_habilidad de la Tarea_Habilidad
	 */
	public void setId_habilidad(String id_habilidad) {
		this.id_habilidad = id_habilidad;
	}

	// TOSTRING Tarea_Habilidad

	/**
	 * @return String con los datos de la Tarea_Habilidad
	 */
	@Override
	public String toString() {
		return "Tarea_Habilidad [id=" + id + ", id_tarea=" + id_tarea + ", id_habilidad=" + id_habilidad + "]";
	}

}
