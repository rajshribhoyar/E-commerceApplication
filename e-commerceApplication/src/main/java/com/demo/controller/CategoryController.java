package com.demo.controller;
import java.util.List;

import com.demo.model.Category;
import com.demo.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }

    @PostMapping("/save")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){

        return new ResponseEntity<Category>(categoryService.saveCategory(category), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id){
        return new ResponseEntity<Category>(categoryService.getCategoryById(id), HttpStatus.OK);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") int id, @RequestBody Category category){
        return new ResponseEntity<Category>(categoryService.getCategoryById(id),HttpStatus.OK);

    }
    @RequestMapping("/categorypage/{pageno}/{pagesize}")
    public Page<Category> categoryPagination(@PathVariable Integer pageno, @PathVariable Integer pagesize){
        return categoryService.getCategoryPagination(pageno, pagesize);

    }
}
