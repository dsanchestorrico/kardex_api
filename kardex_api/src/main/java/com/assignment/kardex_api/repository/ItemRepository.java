package com.assignment.kardex_api.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.kardex_api.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	Collection<Item>findByName(String name);
}
