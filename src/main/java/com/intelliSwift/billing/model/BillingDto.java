package com.intelliSwift.billing.model;

public class BillingDto {
	
	private Integer quantity;
	private Integer productCode;
	private Double productPrice;
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getProductCode() {
		return productCode;
	}
	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public BillingDto(Integer quantity, Integer productCode, Double productPrice) {
		super();
		this.quantity = quantity;
		this.productCode = productCode;
		this.productPrice = productPrice;
	}
		
	
}
