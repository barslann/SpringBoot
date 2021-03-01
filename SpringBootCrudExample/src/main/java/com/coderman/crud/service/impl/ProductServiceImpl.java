package com.coderman.crud.service.impl;

import com.coderman.crud.entity.Product;
import com.coderman.crud.repository.ProductRepository;
import com.coderman.crud.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product>  products){
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Product getProductByName(String productName){
        return productRepository.findByName(productName);
    }

    public String deleteProductById(int productId){
        productRepository.deleteById(productId);
        return "Product with id " +  productId + " is removed!";
    }

    public Product updateProduct(Product product){
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);

        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return productRepository.save(existingProduct);

    }



}
