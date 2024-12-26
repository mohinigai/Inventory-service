package com.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.Inventory;

@RestController
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
	
	List<Inventory> findByPid(Long pid);

}
