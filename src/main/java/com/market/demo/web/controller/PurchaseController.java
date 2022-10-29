package com.market.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.demo.domain.Purchase;
import com.market.demo.domain.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@GetMapping("/all")
	public ResponseEntity<List<Purchase>> getAll() {
		return new ResponseEntity<List<Purchase>>(purchaseService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/client/{id}")
	public ResponseEntity<List<Purchase>> getByClient(@PathVariable("id") String clientId) {
		return purchaseService.getByClient(clientId)
				.map(purchase -> new ResponseEntity<>(purchase, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save")
	public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
		return new ResponseEntity<Purchase>(purchaseService.save(purchase), HttpStatus.CREATED);
	}

}
