package ru.mirea.oop.p3.part2.circles;

class Circle {
    private final double radius;
    Circle(double radius) {
        if (radius < 0) throw new IllegalArgumentException("Радиус не может быть отрицательным");
        this.radius = radius;
    }
    double getRadius() { return radius; }
    double getArea() { return Math.PI * radius * radius; }
}
public class Main {
    static Circle largest(Circle[] circles) {
        if (circles.length == 0) throw new IllegalArgumentException("Массив кругов пуст");
        Circle largest = circles[0];
        for (Circle circle : circles) if (circle.getArea() > largest.getArea()) largest = circle;
        return largest;
    }
    public static void main(String[] args) {
        Circle[] circles = {new Circle(2), new Circle(5), new Circle(3.5), new Circle(1)};
        for (Circle c : circles) System.out.printf("r = %.2f, площадь = %.2f%n", c.getRadius(), c.getArea());
        Circle max = largest(circles);
        System.out.printf("Наибольший круг: r = %.2f, площадь = %.2f%n", max.getRadius(), max.getArea());
    }
}
