/**
 * 
 */
package com.market.demo.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.market.demo.persistence.entity.Producto;

/**
 * @author juaneins_uio
 *
 */
@Repository
public class ProductoRepository {
	private ProductoCrudRepository productoCrudRepository;

	public List<Producto> getAll() {
		return (List<Producto>) productoCrudRepository.findAll();
	}

	public List<Producto> getByCategoria(int idCategoria) {
		return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
	}

	public Optional<List<Producto>> getEscasos(int cantidad) {
		return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
	}
	
	public Optional<Producto> getByCodigoBarras(String codigoBarras) {
		return productoCrudRepository.findByCodigoBarras(codigoBarras);
	}
	
	public Optional<Producto> getProducto(Long id) {
		return productoCrudRepository.findById(id);
	}
	
	public Producto save(Producto p) {
		return productoCrudRepository.save(p);
	}
	
	public void delete(Long id) {
		productoCrudRepository.deleteById(id);
	}

}
