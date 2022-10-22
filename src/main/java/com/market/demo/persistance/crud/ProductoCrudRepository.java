/**
 * 
 */
package com.market.demo.persistance.crud;

import org.springframework.data.repository.CrudRepository;

import com.market.demo.persistance.entity.Producto;

/**
 * @author juaneins_uio
 *
 */
public interface ProductoCrudRepository extends CrudRepository<Producto, Long> {

}
