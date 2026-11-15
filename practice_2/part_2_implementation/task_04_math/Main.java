package ru.mirea.oop.p2.part2.math;

public class Main {
    interface MathCalculable {
        double PI = Math.PI;
        double power(double number, double exponent);
        double complexAbs(double real, double imaginary);
    }

    static class MathFunc implements MathCalculable {
        @Override public double power(double number, double exponent) {
            return Math.pow(number, exponent);
        }
        @Override public double complexAbs(double real, double imaginary) {
            return Math.hypot(real, imaginary);
        }
        double circleLength(double radius) {
            if (radius < 0) throw new IllegalArgumentException("Отрицательный радиус");
            return 2 * PI * radius;
        }
    }

    public static void main(String[] args) {
        MathFunc implementation = new MathFunc();
        MathCalculable calculator = implementation;
        System.out.println("2 в степени 5: " + calculator.power(2, 5));
        System.out.println("Модуль комплексного числа 3 + 4i: " + calculator.complexAbs(3, 4));
        System.out.printf(java.util.Locale.US, "Длина окружности R=5: %.4f%n",
                implementation.circleLength(5));
    }
}
