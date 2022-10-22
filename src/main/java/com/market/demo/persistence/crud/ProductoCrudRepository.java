/**
 * 
 */
package com.market.demo.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.market.demo.persistence.entity.Producto;

/**
 * @author juaneins_uio
 *
 */
public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {

}
