package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Inventory;
import com.task.service.InventoryServiceI;

@RestController
@RequestMapping("/api")
public class InventoryController {
	
	@Autowired
	private InventoryServiceI Inventoryservice;
    
	@PostMapping("/inventory")
	public ResponseEntity<Inventory> CreateInventory(@RequestBody Inventory inventory) {
		Inventory createInventory = Inventoryservice.CreateInventory(inventory);
		return new ResponseEntity<Inventory>(createInventory, HttpStatus.CREATED);
    }
	@GetMapping("/inventory")
	public ResponseEntity<List<Inventory>> getAllInventory() {
		List<Inventory> allInventory = Inventoryservice.getAllInventory();
		return new ResponseEntity<List<Inventory>>(allInventory, HttpStatus.OK);
	}
	@DeleteMapping("/inventory/{id}")
	public ResponseEntity<String> deleteInventory(@PathVariable("id") Long invId) {
		String deleteInventory = Inventoryservice.deleteInventory(invId);
		return new ResponseEntity<String>(deleteInventory, HttpStatus.OK);
	}
	@PutMapping("/inventory/{id}")
	public ResponseEntity<Inventory>updateInventory(@RequestBody Inventory inventory,@PathVariable ("id") Long invId){
		Inventory updateInventory = Inventoryservice.updateInventory(inventory, invId);
		return new ResponseEntity<Inventory>(updateInventory,HttpStatus.CREATED);
	}
	@GetMapping("/inventory/{id}")
	public ResponseEntity<Inventory>getSingleInventory(@PathVariable ("id") Long invId){
		Inventory singleInventory = Inventoryservice.getSingleInventory(invId);
		return new ResponseEntity<Inventory>(singleInventory,HttpStatus.OK);
	}
	@GetMapping("/inventory/product/{id}")
	public ResponseEntity<List<Inventory>>getAllInventoryByProductId(@PathVariable("id") Long pid){
		List<Inventory> inventoryByProduct = Inventoryservice.getInventoryByProduct(pid);
		return new ResponseEntity<List<Inventory>>(inventoryByProduct ,HttpStatus.OK);
		
	}
}
