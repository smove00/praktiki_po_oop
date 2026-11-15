package ru.mirea.oop.p2.part1.priceable;

import java.math.BigDecimal;

public class Main {
    interface Priceable { BigDecimal getPrice(); }

    static class Book implements Priceable {
        private final String title;
        private final BigDecimal price;
        Book(String title, String price) {
            this.title = title;
            this.price = new BigDecimal(price);
        }
        @Override public BigDecimal getPrice() { return price; }
        @Override public String toString() { return "Книга «" + title + "»"; }
    }

    static class Laptop implements Priceable {
        private final String model;
        private final BigDecimal price;
        Laptop(String model, String price) {
            this.model = model;
            this.price = new BigDecimal(price);
        }
        @Override public BigDecimal getPrice() { return price; }
        @Override public String toString() { return "Ноутбук " + model; }
    }

    public static void main(String[] args) {
        Priceable[] goods = {new Book("Java для начинающих", "850.00"), new Laptop("ThinkPad", "78000.00")};
        for (Priceable item : goods) {
            System.out.println(item + ", цена: " + item.getPrice() + " руб.");
        }
    }
}
