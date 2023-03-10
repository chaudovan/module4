package com.baitapss3.service;

import com.baitapss3.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(int id);

    void createProduct(Product product);

    void editProduct(int id, Product product);

    void deleteProduct(int id);

    List<Product> searchProduct(String name);
}
