package com.assignment.kardex_api.controller;

import java.util.Collection;

import javax.validation.constraints.DecimalMin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.kardex_api.model.HistoricalItem;
import com.assignment.kardex_api.model.Item;
import com.assignment.kardex_api.service.HistoricalItemService;
import com.assignment.kardex_api.service.ItemService;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("/item")
public class ItemController {

	private final ItemService itemService;
	private final HistoricalItemService historicalItemService;
	
	@Autowired
	public ItemController(ItemService itemService, HistoricalItemService historicalItemService) {
		// TODO Auto-generated constructor stub
		this.itemService = itemService;
		this.historicalItemService = historicalItemService;
	}
	

	@GetMapping("/")
	Collection<Item> items() {
		return itemService.findAll();
	}
	
	@GetMapping("/{id}")
	Item findById(@PathVariable @NotNull @DecimalMin("0") Long id) {
		return itemService.findById(id);
	}
	
	@GetMapping("/historical/{id}")
	Collection<HistoricalItem> findHistoricalItemById(@PathVariable @NotNull @DecimalMin("0") Long id) {
		return historicalItemService.findByIdItem(id);
	}

	@PostMapping("/add")
	Item newItem(@RequestBody Item newItem) {
		return itemService.save(newItem);
	}
	
	@PostMapping("/weigh")
	Item weighItem(@RequestBody Item item) {
		return itemService.weighItem(item);
	}

}
