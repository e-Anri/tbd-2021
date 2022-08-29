package cl.tbd.backendayni.models;

import org.springframework.data.annotation.Id;

public class Estado_Tarea {

	/**
	 * ATRIBUTOS DE Estado_Tarea
	 * 
	 * @param id        del Estado_Tarea
	 * @param id_estado del Estado_Tarea
	 * @param id_tarea  del Estado_Tarea
	 */
	@Id
	private String id;
	private String id_estado;
	private String id_tarea;

	// CONSTRUCTOR Estado_Tarea
	public Estado_Tarea() {
	}

	// CONSTRUCTOR Estado_Tarea
	public Estado_Tarea(String id, String id_estado, String id_tarea) {
		this.id = id;
		this.id_estado = id_estado;
		this.id_tarea = id_tarea;
	}

	// GETTERS Estado_Tarea

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return id_estado
	 */
	public String getId_estado() {
		return id_estado;
	}

	/**
	 * @return id_tarea
	 */
	public String getId_tarea() {
		return id_tarea;
	}

	// SETTERS Estado_Tarea

	/**
	 * @param id del Estado_Tarea
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param id_estado del Estado_Tarea
	 */
	public void setId_estado(String id_estado) {
		this.id_estado = id_estado;
	}

	/**
	 * @param id_tarea del Estado_Tarea
	 */
	public void setId_tarea(String id_tarea) {
		this.id_tarea = id_tarea;
	}

	// TOSTRING Estado_Tarea

	/**
	 * @return String con los datos del Estado_Tarea
	 */
	@Override
	public String toString() {
		return "Estado_Tarea [id=" + id + ", id_estado=" + id_estado + ", id_tarea=" + id_tarea + "]";
	}

}
