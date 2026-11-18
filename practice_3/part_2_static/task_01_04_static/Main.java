package ru.mirea.oop.p3.part2.statics;

import java.util.Date;

class F {
    int i;
    static String s = "static";
    void imethod() { System.out.println("Метод экземпляра"); }
    static void smethod() { System.out.println("Статический метод"); }
}
class Test {
    int count;
    int getCount() { return count; }
    static int factorial(int n) {
        if (n < 0 || n > 12) throw new IllegalArgumentException("n должно быть от 0 до 12");
        int result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }
}
class Circle {
    private final double radius;
    Circle(double radius) { this.radius = radius; }
    double getArea() { return Math.PI * radius * radius; }
}
class C {
    private final Circle c = new Circle(2);
    void method1() { method2(); }
    void method2() { System.out.println("What is area " + c.getArea()); }
}
public class Main {
    public static void main(String[] args) {
        F f = new F();
        System.out.println("f.i = " + f.i);
        System.out.println("F.s = " + F.s);
        f.imethod(); F.smethod();
        System.out.println("count = " + new Test().getCount());
        System.out.println("5! = " + Test.factorial(5));
        new C().method1();
        Date[] dates = new Date[10];
        dates[0] = new Date();
        System.out.println(dates[0]);
        System.out.println(dates[0].toString());
    }
}
