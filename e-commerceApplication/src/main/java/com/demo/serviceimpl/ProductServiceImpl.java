package com.demo.serviceimpl;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Product;
import com.demo.repository.ProductRepo;
import com.demo.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepository;


    public ProductServiceImpl(ProductRepo productRepository) {
        super();
        this.productRepository = productRepository;
    }


    @Override
    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }


    @Override
    public List<Product> getAllProduct() {

        return productRepository.findAll() ;
    }


    @Override
    public Product getProductById(int id) {

        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()) {
            return product.get();
        }else {
            throw new ResourceNotFoundException("Product", "Id", id);
        }
    }

    @Override
    public Product updateProduct(Product product, int id) {

        Product product2 = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "Id", id));

        product2.setProductName(product.getProductName());
        product2.setProductDescription(product.getProductDescription());
        product2.setProductPrice(product.getProductPrice());
        product2.setProductQuantity(product.getProductQuantity());

        productRepository.save(product2);
        return product2;
    }


    @Override
    public void deleteProduct(int id) {
        productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Product", "Id", id));
        productRepository.deleteById(id);
    }


    @Override
    public Page<Product> getProductPagination(Integer pageno, Integer pagesize) {
        Pageable pageable = PageRequest.of(pageno, pagesize);
        return productRepository.findAll(pageable);
    }

}