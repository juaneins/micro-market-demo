/**
 * 
 */
package com.market.demo.persistance.crud;

import java.util.List;

import com.market.demo.persistance.entity.Producto;

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
