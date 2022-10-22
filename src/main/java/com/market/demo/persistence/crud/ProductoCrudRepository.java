/**
 * 
 */
package com.market.demo.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.market.demo.persistence.entity.Producto;

/**
 * @author juaneins_uio
 *
 */
public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {

	List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

	@Query(name = "select * from productos where id_categoria = ?", nativeQuery = true)
	List<Producto> getByCategoria(int idCategoria);

	Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

	Optional<Producto> findByCodigoBarras(String codigoBarras);

	//Optional<Producto> findById(Long id);
}
