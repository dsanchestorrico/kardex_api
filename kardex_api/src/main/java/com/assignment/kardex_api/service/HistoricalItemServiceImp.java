package com.assignment.kardex_api.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.kardex_api.model.HistoricalItem;
import com.assignment.kardex_api.repository.HistoricalItemRepository;

@Service
public class HistoricalItemServiceImp implements HistoricalItemService{
	@Autowired
	private final HistoricalItemRepository historicalItemRepository;
	
	public HistoricalItemServiceImp(HistoricalItemRepository historicalItemRepository) {
		// TODO Auto-generated constructor stub
		this.historicalItemRepository = historicalItemRepository;
	}

	@Override
	public Collection<HistoricalItem> findByIdItem(Long id) {
		return historicalItemRepository.findByIdItem(id);
	}

}
