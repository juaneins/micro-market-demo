/**
 * 
 */
package com.market.demo.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.market.demo.persistence.entity.Compra;

/**
 * @author juaneins_uio
 *
 */
public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

	Optional<List<Compra>> findByIdCliente(String idCliente);

}
