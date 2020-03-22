package com.assignment.kardex_api.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HistoricalItem {
	
	@Id	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private long idItem;
	private BigDecimal newPrice;
	private BigDecimal oldPrice;
	private BigDecimal weighPrice;
	private BigDecimal qty;
	private BigDecimal stockQty;
	private BigDecimal totalQty;
	private Date regDate;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdItem() {
		return idItem;
	}
	public void setIdItem(long idItem) {
		this.idItem = idItem;
	}
	public BigDecimal getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(BigDecimal newPrice) {
		this.newPrice = newPrice;
	}
	public BigDecimal getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}
	public BigDecimal getWeighPrice() {
		return weighPrice;
	}
	public void setWeighPrice(BigDecimal weighPrice) {
		this.weighPrice = weighPrice;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public BigDecimal getStockQty() {
		return stockQty;
	}
	public void setStockQty(BigDecimal stockQty) {
		this.stockQty = stockQty;
	}
	public BigDecimal getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(BigDecimal totalQty) {
		this.totalQty = totalQty;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
