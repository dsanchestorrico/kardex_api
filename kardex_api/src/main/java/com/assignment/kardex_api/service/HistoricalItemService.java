package com.assignment.kardex_api.service;

import java.util.Collection;

import com.assignment.kardex_api.model.HistoricalItem;

public interface HistoricalItemService {
	Collection<HistoricalItem> findByIdItem(Long id);
}
