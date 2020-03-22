package com.assignment.kardex_api.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Item {
	@Id	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String description;
	private String status;
	private BigDecimal price;
	private BigDecimal qty;
	private BigDecimal lastPrice;
	private Date lastDate;
	
	public Item(String name, String description, String status, BigDecimal price, BigDecimal qty, BigDecimal lastPrice, Date lastDate) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.price = price;
		this.qty = qty;
		this.lastPrice = lastPrice;
		this.lastDate = lastDate;
	}
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public BigDecimal getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(BigDecimal lastPrice) {
		this.lastPrice = lastPrice;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
