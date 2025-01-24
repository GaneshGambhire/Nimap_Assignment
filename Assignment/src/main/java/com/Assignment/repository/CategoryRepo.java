package com.Assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Assignment.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
