package com.baitapss3.repository;

import com.baitapss3.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository{
    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"Iphone",10000.0,"Sách Tay"));
        productList.add(new Product(2,"Iphone",10000.0,"Nội Địa"));
        productList.add(new Product(3,"Iphone",10000.0,"Loại Thứ 3"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product newPeoduct = null;
        for (Product x:productList) {
            if(x.getIdProduct()==id){
                newPeoduct = new Product(x.getIdProduct(),x.getNameProduct(),x.getPriceProduct(),x.getTypeProduct());
            }
        }
        return newPeoduct;
    }

    @Override
    public void createProduct(Product product) {
        productList.add(product);
    }

    @Override
    public void editProduct(int id, Product product) {
        for (Product x:productList) {
            if(x.getIdProduct()==id){
                x.setNameProduct(product.getNameProduct());
                x.setPriceProduct(product.getPriceProduct());
                x.setTypeProduct(product.getTypeProduct());
            }
        }

    }

    @Override
    public void deleteProduct(int id) {
        productList.remove(id-1);
    }

    @Override
    public List<Product> searchProduct(String name) {
        List<Product> products = new ArrayList<>();
        for (Product x:productList) {
            if(x.getNameProduct().contains(name)){
                products.add(x);
            }
        }
        return products;
    }
}
