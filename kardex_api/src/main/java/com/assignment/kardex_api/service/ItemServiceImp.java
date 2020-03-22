package com.assignment.kardex_api.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.kardex_api.model.HistoricalItem;
import com.assignment.kardex_api.model.Item;
import com.assignment.kardex_api.repository.HistoricalItemRepository;
import com.assignment.kardex_api.repository.ItemRepository;

@Service
public class ItemServiceImp implements ItemService {

	@Autowired
	private final ItemRepository itemRepository;
	@Autowired
	private final HistoricalItemRepository historicalItemRepository;
	
	public ItemServiceImp(ItemRepository itemRepository, HistoricalItemRepository historicalItemRepository) {
		this.itemRepository = itemRepository;
		this.historicalItemRepository = historicalItemRepository;
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
			
			HistoricalItem historical = new HistoricalItem();
			historical.setIdItem(tmp.getId());
			historical.setNewPrice(item.getPrice());
			historical.setOldPrice(tmp.getPrice());
			historical.setWeighPrice(weighPrice);
			historical.setQty(item.getQty());
			historical.setStockQty(tmp.getQty());
			historical.setTotalQty(totalQty);
			
			historicalItemRepository.save(historical);
			
			
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

	@Override
	public Item findById(Long id) {
		return itemRepository.findById(id).get();
	}

}
