package com.intelliSwift.billing;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intelliSwift.billing.controllers.PoductController;
import com.intelliSwift.billing.model.Product;
import com.intelliSwift.billing.service.BillingService;
import com.intelliSwift.billing.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestCases {

	@InjectMocks
	PoductController poductController;

	@Mock
	ProductService productService;

	@Mock
	BillingService billingService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddProduct() {

		Product product = new Product(1, "ParleG", "B", 12345);
		when(productService.addProduct(product)).thenReturn(product);

		assertEquals("B", product.getCategory());
		assertEquals("ParleG", product.getName());
		assertEquals(Integer.valueOf(12345), product.getProductCode());

	}

	@Test
	public void testUpdateProduct() {

		Product product = new Product(1, "ParleG", "B", 12345);
		when(productService.addProduct(product)).thenReturn(product);

		assertEquals("B", product.getCategory());
		assertEquals("ParleG", product.getName());
		assertEquals(Integer.valueOf(12345), product.getProductCode());

	}

	@Test
	public void testGetAllProduct() {
		List<Product> list = new ArrayList<Product>();
		Product pOne = new Product(1, "ParleG", "B", 12345);
		Product pTwo = new Product(2, "CrackJack", "B", 1234);
		Product pThree = new Product(3, "Apple", "A", 123);

		list.add(pOne);
		list.add(pTwo);
		list.add(pThree);

		when(productService.getAllProduct()).thenReturn(list);
		List<Product> empList = productService.getAllProduct();

		assertEquals(3, empList.size());
		verify(productService, times(1)).getAllProduct();
	}

	@Test
	public void testGetProduct() {
		when(productService.getProduct(1)).thenReturn(new Product(1, "ParleG", "B", 12345));

		Product product = productService.getProduct(1);

		assertEquals("B", product.getCategory());
		assertEquals("ParleG", product.getName());
		assertEquals(Integer.valueOf(12345), product.getProductCode());
	}

	@Test
	public void testDeleteProduct() {

		when(productService.deleteProduct(1)).thenReturn("Deleted Successfully");
		Product pOne = new Product(1, "ParleG", "B", 12345);
		productService.deleteProduct(pOne.getId());

	}
	
	
	
	

}
