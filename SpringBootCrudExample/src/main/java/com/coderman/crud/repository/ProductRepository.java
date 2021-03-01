package com.coderman.crud.repository;

import com.coderman.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {
    Product findByName(String productName);
}
