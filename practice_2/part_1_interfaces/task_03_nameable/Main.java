package ru.mirea.oop.p2.part1.nameable;

public class Main {
    interface Nameable { String getName(); }

    static class Planet implements Nameable {
        private final String name;
        Planet(String name) { this.name = name; }
        @Override public String getName() { return name; }
    }

    static class Car implements Nameable {
        private final String brand;
        Car(String brand) { this.brand = brand; }
        @Override public String getName() { return brand; }
    }

    static class Animal implements Nameable {
        private final String name;
        Animal(String name) { this.name = name; }
        @Override public String getName() { return name; }
    }

    public static void main(String[] args) {
        Nameable[] objects = {new Planet("Марс"), new Car("Audi"), new Animal("Барсик")};
        for (Nameable object : objects) {
            System.out.println(object.getClass().getSimpleName() + ": " + object.getName());
        }
    }
}
