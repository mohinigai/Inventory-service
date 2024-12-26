package com.task.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.task.model.Inventory;
import com.task.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryServiceI {

	@Autowired
	private InventoryRepository inventoryRepositroy;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Inventory CreateInventory(Inventory inventory) {
		Inventory saveInventory = inventoryRepositroy.save(inventory);
		return saveInventory;
	}
	@Override
	public List<Inventory> getAllInventory() {
		List<Inventory> collect = inventoryRepositroy.findAll().stream().map(b -> b).collect(Collectors.toList());
		return collect;
	}
	@Override
	public String deleteInventory(Long invId) {

		String message = null;
		if (!inventoryRepositroy.existsById(invId)) {
			inventoryRepositroy.deleteById(invId);
			message = "Inventory deleted successfully";
		} else {
			message = "Inventory not found";
		}
		return message;
	}

	@Override
	public Inventory getSingleInventory(Long invId) {
		Inventory byId = inventoryRepositroy.findById(invId).orElseThrow(()->new RuntimeException("Inventory Id not found "+invId));
		return byId;
	}
	@Override
	public Inventory updateInventory(Inventory inventory, Long invId) {
		Inventory byId = inventoryRepositroy.findById(invId).orElseThrow(()->new RuntimeException("Inventory Id not found "+invId));
		byId.setQuantity(inventory.getQuantity());
		byId.setIsactive(inventory.getIsactive());
		Inventory updatedInventory = inventoryRepositroy.save(byId);
		return updatedInventory;
	}
	@Override
	public List<Inventory> getInventoryByProduct(Long pid) {
		List<Inventory> byProductId = inventoryRepositroy.findByPid(pid);
		return byProductId;
	}
}
