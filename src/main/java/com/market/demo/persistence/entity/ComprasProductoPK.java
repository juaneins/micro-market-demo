/**
 * 
 */
package com.market.demo.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author juaneins_uio
 *
 */
@Embeddable
public class ComprasProductoPK implements Serializable {

	private static final long serialVersionUID = -282515291384294805L;
	@Column(name = "id_compra")
	private Integer idCompra;
	@Column(name = "id_producto")
	private Integer idProducto;

	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

}
