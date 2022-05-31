package com.buzas.spring.secondLesson.items;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void initialize() {
        this.products = new ArrayList<>();
        addItemsIntoList();
    }

    private void addItemsIntoList() {
        for (int i = 0; i < 5; i++) {
            int cost = (int) (Math.random() * 500);
            products.add(new Product(i, "Product №" + (i + 1), cost));
        }
    }

//    У меня проект на 17 дваже, он не дает использовать Optional, быстрый гугл не дал аналога, так что сделал чуть иначе
    public Product findProduct(String name) throws NullPointerException {
        for (Product product : products) {
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public Product findProduct(int id) throws NullPointerException {
        for (Product product : products) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public List<Product> showContent() {
        return Collections.unmodifiableList(products);
    }
}
