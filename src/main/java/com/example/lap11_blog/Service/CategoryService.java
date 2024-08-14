package com.example.lap11_blog.Service;

import com.example.lap11_blog.Api.ApiException;
import com.example.lap11_blog.Model.Category;
import com.example.lap11_blog.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory( int id , Category category) {
        Category category1 = categoryRepository.findById(id);
        if(category1 == null) {
            throw new ApiException("category not found");
        }
        category1.setName(category.getName());
        categoryRepository.save(category1);
    }

    public void deleteCategory(int id) {
        Category category = categoryRepository.findById(id);
        if(category == null) {
            throw new ApiException("category not found");
        }
        categoryRepository.delete(category);
    }
}
