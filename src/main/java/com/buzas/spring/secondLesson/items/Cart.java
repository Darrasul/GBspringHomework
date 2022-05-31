package com.buzas.spring.secondLesson.items;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void add(Product product) {
        products.add(product);
    }

    public void remove(String name){
        for (Product product : products) {
            if (product.getName().equals(name)){
                products.remove(product);
            }
        }
    }

    public void remove(int id){
        for (Product product : products) {
            if (product.getId() == id){
                products.remove(product);
            }
        }
    }

    public Product findProduct(int id) throws NullPointerException{
        for (Product product : products) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public Product findProduct(String name) throws NullPointerException {
        for (Product product : products) {
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public void removeAll() {
        products.clear();
    }

    public int getSize() {
        return this.products.size();
    }

    public List<Product> getList() {
        return products;
    }

    @Override
    public String toString() {
        return "ProductRepository{" +
                "products=\n" + products + "\n" +
                '}';
    }
}
