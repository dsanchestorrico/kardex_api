package com.assignment.kardex_api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.kardex_api.model.Item;
import com.assignment.kardex_api.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {

	private final ItemService itemService;
	
	@Autowired
	public ItemController(ItemService itemService) {
		// TODO Auto-generated constructor stub
		this.itemService = itemService;
	}
	

	@GetMapping("/all")
	Collection<Item> items() {
		return itemService.findAll();
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
