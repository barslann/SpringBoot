package com.coderman.crud.service;

import com.coderman.crud.entity.Product;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> saveProducts(List<Product>  products);
    List<Product> getProducts();
    Product getProductById(int id);
    Product getProductByName(String productName);
    Product updateProduct(Product product);
    String deleteProductById(int productId);
}
