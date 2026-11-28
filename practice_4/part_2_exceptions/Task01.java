package ru.mirea.oop.p4.exceptions;

/** Задание 1. Деление на ноль для целого и вещественного типа; try-catch. */
public class Task01 {
    public void exceptionDemo() {
        try {
            int zero = 0;
            System.out.println(2 / zero);
        } catch (ArithmeticException ex) {
            System.out.println("Attempted division by zero: " + ex.getMessage());
        }
        // В отличие от int, вещественное деление даёт Infinity, а не исключение.
        System.out.println("2.0 / 0.0 = " + (2.0 / 0.0));
    }

    public static void main(String[] args) {
        new Task01().exceptionDemo();
    }
}
