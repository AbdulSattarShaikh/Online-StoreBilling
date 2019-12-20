package com.intelliSwift.billing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelliSwift.billing.exceptions.BadRequestException;
import com.intelliSwift.billing.model.Product;
import com.intelliSwift.billing.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	
	@Override
	public String editProduct(Product product) {
		
		Product dbProduct = productRepo.findById(product.getId()).orElseThrow(()->new BadRequestException("Object not Found"));
 		
		if (dbProduct != null) {
			
			dbProduct.setCategory(product.getCategory());
			dbProduct.setName(product.getName());
			
			productRepo.save(dbProduct);
					
		}		
		return "The product "+dbProduct.getId()+" is Updated successfully";
	}

	@Override
	public Product getProduct(Integer id) {
		return productRepo.findById(id).orElseThrow(()->new BadRequestException("Object not Found"));
	}

	@Override
	public List<Product> getAllProduct() {			
		return productRepo.findAll();
	}

	@Override
	public String deleteProduct(Integer id) throws BadRequestException{		
		
		productRepo.deleteById(id);
		return "Successfully Deleted" ;
	}	

}
