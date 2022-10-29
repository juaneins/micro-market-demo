/**
 * 
 */
package com.market.demo.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.market.demo.domain.Purchase;
import com.market.demo.domain.repository.PurchaseRepository;
import com.market.demo.persistence.crud.CompraCrudRepository;
import com.market.demo.persistence.entity.Compra;
import com.market.demo.persistence.mapper.PurchaseMapper;

/**
 * @author juaneins_uio
 *
 */
@Repository
public class CompraRepository implements PurchaseRepository {
	
	@Autowired
	private CompraCrudRepository compraCrudRepository;
	
	@Autowired
	private PurchaseMapper mapper;

	@Override
	public List<Purchase> getAll() {
		return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());		
	}

	@Override
	public Optional<List<Purchase>> getByClient(String clientId) {
		return compraCrudRepository.findByIdCliente(clientId)
				.map(compras -> mapper.toPurchases(compras));		
	}

	@Override
	public Purchase save(Purchase purchase) {
		Compra compra = mapper.toCompra(purchase);
		compra.getProductos().forEach(producto -> producto.setCompra(compra));
		return mapper.toPurchase(compraCrudRepository.save(compra));
	}

}
