package com.demo.service;

import com.demo.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategory();
    Category getCategoryById(int id);
    Category updateCategory(Category category, int id);
    void deleteCategory(int id);
    Page<Category> getCategoryPagination(Integer pageno, Integer pagesize);
}
