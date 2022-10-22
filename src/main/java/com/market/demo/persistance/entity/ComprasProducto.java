/**
 * 
 */
package com.market.demo.persistance.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author juaneins_uio
 *
 */
@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

	@EmbeddedId
	private ComprasProductoPK id;

	@Column(name = "cantidad")
	private Integer cantidad;

	@Column(name = "total")
	private Double total;

	@Column(name = "estado")
	private Boolean estado;

	public ComprasProductoPK getId() {
		return id;
	}

	public void setId(ComprasProductoPK id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
