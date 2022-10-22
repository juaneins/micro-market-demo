/**
 * 
 */
package com.market.demo.persistence.crud;

import java.util.List;

import com.market.demo.persistence.entity.Producto;

/**
 * @author juaneins_uio
 *
 */
public class ProductoRepository {
	private ProductoCrudRepository productoCrudRepository;
	
	public List<Producto> getAll() {
		return (List<Producto>) productoCrudRepository.findAll();
	}
	
}
