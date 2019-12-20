
package com.intelliSwift.billing.model;


public class BillingInfo {

	private Integer id;
	private Double tax;
	private Double finalAmount;
	private String name;
	private Integer quantity;
	private Double price;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer long1) {
		this.id = long1;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(Double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
