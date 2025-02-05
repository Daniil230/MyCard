package com.example.mycard;

public class CardImage {
    private String name;

    @Override
    public String toString() {
        return "CardImage{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public CardImage(String name) {
        this.name = name;
    }
}
