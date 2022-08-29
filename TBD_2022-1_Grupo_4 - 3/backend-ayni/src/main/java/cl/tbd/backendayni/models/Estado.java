package cl.tbd.backendayni.models;

import org.springframework.data.annotation.Id;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Estado {
	/**
	 * ATRIBUTOS DE ESTADO
	 * 
	 * @param id     del estado
	 * @param nombre del estado
	 */

	@Id
	private String id;
	private String nombre;

	public Estado() {
	}

	// CONSTRUCTOR Estado
	public Estado(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	// GETTERS Estado

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return estado nombre
	 */
	public String getNombre() {
		return nombre;
	}

	// SETTERS Estado
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

	// TOSTRING Estado

	/**
	 * @return string con los datos del estado
	 */
	@Override
	public String toString() {
		return "Estado [id=" + id + ", nombre=" + nombre + "]";
	}
}
