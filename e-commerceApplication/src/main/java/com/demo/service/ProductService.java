package com.demo.service;

import com.demo.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProduct();
    Product getProductById(int id);
    Product updateProduct(Product product, int id);
    void deleteProduct(int id);
    Page<Product> getProductPagination(Integer pageno, Integer pagesize);

}
