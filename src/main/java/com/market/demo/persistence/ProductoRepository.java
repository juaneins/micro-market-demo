/**
 * 
 */
package com.market.demo.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.market.demo.domain.Product;
import com.market.demo.domain.repository.ProductRepository;
import com.market.demo.persistence.crud.ProductoCrudRepository;
import com.market.demo.persistence.entity.Producto;
import com.market.demo.persistence.mapper.ProductMapper;

/**
 * @author juaneins_uio
 *
 */
@Repository
public class ProductoRepository implements ProductRepository {

	private ProductoCrudRepository productoCrudRepository;
	private ProductMapper mapper;

	public ProductoRepository(ProductoCrudRepository productoCrudRepository, ProductMapper mapper) {
		this.productoCrudRepository = productoCrudRepository;
		this.mapper = mapper;
	}

	@Override
	public List<Product> getAll() {
		List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
		return mapper.toProducts(productos);
	}

	public Optional<Producto> getByCodigoBarras(String codigoBarras) {
		return productoCrudRepository.findByCodigoBarras(codigoBarras);
	}

	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScarseProducts(int quantity) {
		Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,
				true);
		return productos.map(prod -> mapper.toProducts(prod));
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
	}

	@Override
	public Product save(Product product) {
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productoCrudRepository.save(producto));
	}

	@Override
	public void delete(int id) {
		productoCrudRepository.deleteById(id);
	}

}
