package com.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column(name="Id")
    private int id;

    @Column(name="productName")
    private String productName;

    @Column(name="productDescription")
    private String productDescription;

    @Column(name="productPrice")
    private String productPrice;

    @Column(name="productQuantity")
    private String productQuantity;

    @ManyToOne
    private Category category;



    public Product() {

    }

    public Product(int id, String productName, String productDescription, String productPrice,
                   String productQuantity) {
        super();
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", productName=" + productName
                + ", productDescription=" + productDescription + ", productPrice=" + productPrice + ", productQuantity="
                + productQuantity + "]";
    }
}
