package com.demo.serviceimpl;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Category;
import com.demo.repository.CategoryRepo;
import com.demo.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepo categoryRepository;


    public CategoryServiceImpl(CategoryRepo categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category saveCategory(Category category) {

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {

        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(int id) {

        Optional<Category> category = categoryRepository.findById(id);

        if(category.isPresent()) {
            return category.get();
        }else {
            throw new ResourceNotFoundException("Category", "Id", id);
        }
    }

    @Override
    public Category updateCategory(Category category, int id) {
        Category category2 = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category", "Id", id));

        category2.setCategoryName(category.getCategoryName());
        category2.setCategoryDescription(category.getCategoryDescription());

        categoryRepository.save(category2);

        return category2;
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category", "Id", id));
        categoryRepository.deleteById(id);
    }

    @Override
    public Page<Category> getCategoryPagination(Integer pageno, Integer pagesize) {
        Pageable pageable = PageRequest.of(pageno, pagesize);
        return categoryRepository.findAll(pageable);
    }

}

