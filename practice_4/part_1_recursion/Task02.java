package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** Задание 2. Вывести от 1 до n с помощью рекурсии. */
public class Task02 {
    private static void append(int value, int n, StringBuilder result) {
        if (value > n) return; // базовый случай
        if (result.length() > 0) result.append(' ');
        result.append(value);
        append(value + 1, n, result);
    }

    public static String sequence(int n) {
        if (n <= 0) throw new IllegalArgumentException("n должно быть натуральным");
        StringBuilder result = new StringBuilder();
        append(1, n, result);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (!input.hasNextInt()) {
            System.err.println("Введите натуральное число n");
            return;
        }
        try {
            System.out.println(sequence(input.nextInt()));
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
