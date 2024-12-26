package com.task.service;

import java.util.List;

import com.task.model.Inventory;

public interface InventoryServiceI {
	
	public Inventory CreateInventory(Inventory inventory);
	
	public List<Inventory> getAllInventory();
	
	public String deleteInventory(Long invId );
	
	public Inventory getSingleInventory(Long invId);
	
	public Inventory updateInventory(Inventory inventory,Long invId);

	public List<Inventory>getInventoryByProduct(Long pid);
}
