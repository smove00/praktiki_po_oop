package ru.mirea.oop.p3.part2.circles;

import java.util.Random;

public class Main {
    static class Circle {
        private final double radius;
        private static int numberOfObjects;
        Circle(double radius) {
            if (!Double.isFinite(radius) || radius < 0) throw new IllegalArgumentException("Radius");
            this.radius = radius;
            numberOfObjects++;
        }
        double getRadius() { return radius; }
        double getArea() { return Math.PI * radius * radius; }
        static int getNumberOfObjects() { return numberOfObjects; }
    }

    static Circle largest(Circle[] circles) {
        if (circles == null || circles.length == 0) throw new IllegalArgumentException("Empty array");
        Circle best = null;
        for (Circle circle : circles) {
            if (circle == null) throw new IllegalArgumentException("Null circle");
            if (best == null || circle.getArea() > best.getArea()) best = circle;
        }
        return best;
    }

    public static void main(String[] args) {
        Circle[] circles = new Circle[10];
        Random random = new Random(42);
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(1 + random.nextDouble() * 20);
            System.out.printf(java.util.Locale.US, "Круг %2d: радиус=%.2f, площадь=%.2f%n",
                i + 1, circles[i].getRadius(), circles[i].getArea());
        }
        Circle best = largest(circles);
        System.out.printf(java.util.Locale.US, "Наибольшая площадь %.2f при радиусе %.2f%n",
            best.getArea(), best.getRadius());
        System.out.println("Создано кругов: " + Circle.getNumberOfObjects());
        if (best.getArea() < circles[0].getArea()) throw new AssertionError();
    }
}
