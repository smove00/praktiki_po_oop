package ru.mirea.oop.p3.part2.statics;

import java.util.Date;

public class Main {
    // Методичка, задание 1: какие обращения к членам F допустимы.
    static class F {
        int i = 7;                // принадлежит экземпляру
        static String s = "hello"; // принадлежит классу
        void imethod() { System.out.println("instance method"); }
        static void smethod() { System.out.println("static method"); }
    }

    // Задание 2: main обязательно static, getCount зависит от экземпляра,
    // factorial не зависит от состояния и может быть static.
    static class Counter {
        private int count = 5;
        int getCount() { return count; }
        static long factorial(int n) {
            if (n < 0 || n > 20) throw new IllegalArgumentException("0 <= n <= 20");
            long result = 1;
            for (int i = 2; i <= n; i++) result *= i;
            return result;
        }
    }

    // Задание 3: экземплярный метод нельзя вызывать из static-контекста без объекта.
    static class C {
        private final Circle circle = new Circle(3);
        void method1() { method2(); }
        void method2() { System.out.printf("Площадь круга: %.2f%n", circle.getArea()); }
    }
    static class Circle {
        private final double radius;
        Circle(double radius) { this.radius = radius; }
        double getArea() { return Math.PI * radius * radius; }
    }

    public static void main(String[] args) {
        F f = new F();
        System.out.println("1. f.i: " + f.i);       // допустимо
        System.out.println("2. f.s: " + f.s);       // допустимо, но лучше F.s
        f.imethod();                               // допустимо
        f.smethod();                               // допустимо, но лучше F.smethod()
        System.out.println("6. F.s: " + F.s);       // допустимо
        F.smethod();                               // допустимо
        // F.i и F.imethod() недопустимы, требуют объект F.

        Counter counter = new Counter();
        System.out.println("getCount=" + counter.getCount());
        System.out.println("5!=" + Counter.factorial(5));

        new C().method1();                         // исправление задания 3

        // Задание 4: массив содержит null, пока каждый элемент не инициализирован.
        Date[] dates = new Date[10];
        for (int i = 0; i < dates.length; i++) dates[i] = new Date();
        System.out.println("dates[0]=" + dates[0]);
        System.out.println("dates[0].toString()=" + dates[0].toString());
    }
}
