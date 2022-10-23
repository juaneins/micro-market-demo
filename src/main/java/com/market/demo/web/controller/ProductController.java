/**
 * 
 */
package com.market.demo.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.demo.domain.Product;
import com.market.demo.domain.service.ProductService;

/**
 * @author juaneins_uio
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	public List<Product> getAll() {
		return productService.getAll();
	}
	
	public Optional<Product> getProduct(int productId) {
		return productService.getProduct(productId);
	}
	
	Optional<List<Product>> getByCategory(int categoryId) {
		return productService.getByCategory(categoryId);
	}
	
	public  Product save(Product product) {
		return productService.save(product);
	}
	
	public boolean delete(int productId) {
		return productService.delete(productId);
	}
}
