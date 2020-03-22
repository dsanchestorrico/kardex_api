package com.assignment.kardex_api.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.kardex_api.model.HistoricalItem;

public interface HistoricalItemRepository extends JpaRepository<HistoricalItem, Long>{
	Collection<HistoricalItem> findByIdItem(Long id);
}
