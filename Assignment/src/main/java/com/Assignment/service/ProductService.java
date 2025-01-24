package com.Assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Assignment.entity.Product;
import com.Assignment.repository.ProductRepo;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Page<Product> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepo.findAll(pageable);
    }

    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }
    
    public Product updateProduct(int id, Product updatedProduct) {
        Optional<Product> existingProductOpt = productRepo.findById(id);
        
        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            
            // Update the product details
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setQty(updatedProduct.getQty());
            existingProduct.setPrice(updatedProduct.getPrice());
            
            return productRepo.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found with ID " + id);
        }
    }
    
    public void deleteProductById(int id) {
        productRepo.deleteById(id);
    }
}
