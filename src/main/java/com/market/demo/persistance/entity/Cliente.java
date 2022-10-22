/**
 * 
 */
package com.market.demo.persistance.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author juaneins_uio
 *
 */
@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellidos")
	private String apellido;

	@Column(name = "celular")
	private Long celular;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "correo_electronico")
	private String correoElectronico;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

}
