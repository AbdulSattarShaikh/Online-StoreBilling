package com.intelliSwift.billing.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intelliSwift.billing.model.Product;
import com.intelliSwift.billing.service.ProductService;

@RestController
@RequestMapping("/product")
public class PoductController {

	@Autowired
	ProductService productService;

	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
	}
	
	@PutMapping()
	public ResponseEntity<String> editProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.editProduct(product), HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Integer id) {
		return new ResponseEntity<>(productService.getProduct(id), HttpStatus.OK);
	}	
	
	@GetMapping()
	public ResponseEntity<List<Product>> getAllProduct() {
		return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
		return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
	}
	
}
