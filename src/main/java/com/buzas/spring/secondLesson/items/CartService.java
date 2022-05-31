package com.buzas.spring.secondLesson.items;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
public class CartService {
    private Cart repo;

    @PostConstruct
    public void initialize() {
        this.repo = new Cart();
    }

    public void addProduct (Product product) {
        repo.add(product);
    }

    public void removeProduct (Product product) {
        repo.remove(product.getName());
    }

    public Product findProduct (int id) throws NullPointerException{
        return repo.findProduct(id);
    }

    public Product findProduct (String name) throws NullPointerException{
        return repo.findProduct(name);
    }

    public void removeAll () {
        repo.removeAll();
    }

    public int getRepoLength() {
        return repo.getSize();
    }

    public Cart getRepo() {
        return repo;
    }

}
