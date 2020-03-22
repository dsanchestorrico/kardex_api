package com.assignment.kardex_api.service;

import java.util.Collection;
import com.assignment.kardex_api.model.Item;

public interface ItemService {
	
	Item weighItem(Item item);
	
	Collection<Item> findAll();
	
	Item save(Item item);
}
