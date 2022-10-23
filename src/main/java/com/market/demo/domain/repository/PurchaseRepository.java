/**
 * 
 */
package com.market.demo.domain.repository;

import java.util.List;
import java.util.Optional;

import com.market.demo.domain.Purchase;

/**
 * @author juaneins_uio
 *
 */
public interface PurchaseRepository {

	List<Purchase> getAll();
	Optional<List<Purchase>> getByClient(String clientId);
	Purchase save(Purchase purchase);
	
}
