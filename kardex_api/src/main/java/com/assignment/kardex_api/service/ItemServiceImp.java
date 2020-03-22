package com.assignment.kardex_api.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.kardex_api.model.Item;
import com.assignment.kardex_api.repository.ItemRepository;

@Service
public class ItemServiceImp implements ItemService {

	@Autowired
	private final ItemRepository itemRepository;

	
	public ItemServiceImp(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public Item weighItem(Item item) {
		Optional<Item> aux = itemRepository.findById(item.getId());
		if(aux.get()!= null) {
			Item tmp = aux.get();
			BigDecimal totalQty = tmp.getQty().add(item.getQty());
			BigDecimal buyPrice = item.getPrice().multiply(item.getQty());
			BigDecimal stockPrice =tmp.getPrice().multiply(tmp.getQty());
			BigDecimal weighPrice = (buyPrice.add(stockPrice)).divide(totalQty, RoundingMode.HALF_UP);
			
			item.setQty(totalQty);
			item.setPrice(weighPrice);
			item.setLastDate(new Date());
			
		}
		itemRepository.save(item);
		return item;
	}

	@Override
	public Collection<Item> findAll() {
		return itemRepository.findAll();		
	}

	@Override
	public Item save(Item item) {
		return itemRepository.save(item);
	}

}
