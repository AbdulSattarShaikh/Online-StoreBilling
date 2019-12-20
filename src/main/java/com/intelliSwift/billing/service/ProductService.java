package com.intelliSwift.billing.service;

import java.util.List;

import com.intelliSwift.billing.model.Product;

public interface ProductService {

	Product addProduct(Product product);
	
	String editProduct(Product product);

	Product getProduct(Integer id);

	List<Product> getAllProduct();

	String deleteProduct(Integer id);



}
