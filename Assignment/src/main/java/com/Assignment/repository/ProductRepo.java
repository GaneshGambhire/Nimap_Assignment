package com.Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Assignment.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
