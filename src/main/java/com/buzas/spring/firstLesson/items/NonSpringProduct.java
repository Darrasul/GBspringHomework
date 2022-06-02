package com.buzas.spring.firstLesson.items;

public class NonSpringProduct {
    private int id;
    private String title;
    private String cost;

    public NonSpringProduct(int id, String title, String cost){
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public NonSpringProduct(int id, String title, int cost){
        this.id = id;
        this.title = title;
        this.cost = cost + " рублей";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setCost(int cost) {
        this.cost = cost + " рублей";
    }
}
