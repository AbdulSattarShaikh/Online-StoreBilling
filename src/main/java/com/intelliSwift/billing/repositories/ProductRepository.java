package com.intelliSwift.billing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelliSwift.billing.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByproductCode(Integer productCode);

}
