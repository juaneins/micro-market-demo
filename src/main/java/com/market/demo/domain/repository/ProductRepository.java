/**
 * 
 */
package com.market.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.market.demo.domain.Product;

/**
 * @author juaneins_uio
 *
 */
public interface ProductRepository {
	
	public List<Product> getAll();

	Optional<List<Product>> getBycategory(int categoryId);

	Optional<List<Product>> getScarseProducts(int quantity);

	Optional<Product> getProduct(int productId);

	Product save(Product product);

	void delete(int productId);
}
