package com.Assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Assignment.entity.Category;
import com.Assignment.repository.CategoryRepo;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Page<Category> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return categoryRepo.findAll(pageable);
    }

    public Optional<Category> getCategoryById(int id) {
        return categoryRepo.findById(id);
    }

    public Category saveCategory(Category category) {
        return categoryRepo.save(category);
    }
    
    public Category updateCategory(int id, Category updatedCategory) {
        Optional<Category> existingCategory = categoryRepo.findById(id);

        if (existingCategory.isPresent()) {
            Category category = existingCategory.get();
            category.setCategoryName(updatedCategory.getCategoryName());
            category.setProducts(updatedCategory.getProducts());
            return categoryRepo.save(category);
        } else {
            throw new RuntimeException("Category not found with id: " + id);
        }
    }

    public void deleteCategoryById(int id) {
        categoryRepo.deleteById(id);
    }
}
