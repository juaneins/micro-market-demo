/**
 * 
 */
package com.market.demo.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/all")
	public List<Product> getAll() {
		return productService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Product> getProduct(@PathVariable("id") int productId) {
		return productService.getProduct(productId);
	}
	
	@GetMapping("/category/{id}")
	public Optional<List<Product>> getByCategory(@PathVariable("id") int categoryId) {
		return productService.getByCategory(categoryId);
	}
	
	@PostMapping("/save")
	public  Product save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean delete(@PathVariable("id") int productId) {
		return productService.delete(productId);
	}
}
