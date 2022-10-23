/**
 * 
 */
package com.market.demo.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.market.demo.domain.Product;
import com.market.demo.domain.repository.ProductRepository;

/**
 * @author juaneins_uio
 *
 */
@Service
public class ProductService {
	
	private ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {		
		this.productRepository = productRepository;
	}
	
	public List<Product> getAll() {
		return productRepository.getAll();
	}
	
	public Optional<Product> getProduct(int productId) {
		return productRepository.getProduct(productId);
	}
	
	public Optional<List<Product>> getByCategory(int categoryId) {
		return productRepository.getByCategory(categoryId);
	}	

	public  Product save(Product product) {
		return productRepository.save(product);
	}

	public boolean delete(int productId) {
		return getProduct(productId).map(product -> {
			productRepository.save(product);
			return true;
		}).orElse(false);
	}

}
