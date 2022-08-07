package com.demo.controller;
import java.util.List;

import com.demo.model.Product;
import com.demo.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){

        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public List<Product> getAllProduct(){
        return productService.getAllProduct();

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id){

        return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product){

        return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
        productService.deleteProduct(id);
        return new ResponseEntity<String>("Product Deleted Successfully. ",HttpStatus.OK);
    }

    @RequestMapping("/page/{pageno}/pagesize")
    public Page<Product> productPagination(@PathVariable Integer pageno, @PathVariable Integer pagesize){
        return productService.getProductPagination(pageno, pagesize);

    }
}
