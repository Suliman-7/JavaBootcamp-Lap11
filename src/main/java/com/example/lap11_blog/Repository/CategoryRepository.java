package com.example.lap11_blog.Repository;

import com.example.lap11_blog.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    Category findById(int id);




}
