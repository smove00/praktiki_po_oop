package ru.mirea.oop.p4.exceptions;

/** Задание 1: целочисленное и вещественное деление на ноль, try/catch. */
public class Task01 {
    static class Exception1 {
        void exceptionDemo() {
            try {
                System.out.println(2 / 0);
            } catch (ArithmeticException e) {
                System.out.println("Attempted division by zero");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("2 / 0: ArithmeticException (деление целых чисел)");
        new Exception1().exceptionDemo();
        System.out.println("2.0 / 0.0 = " + (2.0 / 0.0)); // Infinity, не исключение
    }
}
