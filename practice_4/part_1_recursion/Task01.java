package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** Задание 1. Первые n элементов треугольной последовательности: 1 2 2 3 3 3 ... */
public class Task01 {
    private static void build(int remaining, int number, int occurrences, StringBuilder result) {
        if (remaining == 0) return; // базовый случай
        if (result.length() > 0) result.append(' ');
        result.append(number);
        if (occurrences + 1 == number) {
            build(remaining - 1, number + 1, 0, result);
        } else {
            build(remaining - 1, number, occurrences + 1, result);
        }
    }

    public static String firstTerms(int n) {
        if (n <= 0) throw new IllegalArgumentException("n должно быть натуральным");
        StringBuilder result = new StringBuilder();
        build(n, 1, 0, result);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (!input.hasNextInt()) {
            System.err.println("Введите натуральное число n");
            return;
        }
        try {
            System.out.println(firstTerms(input.nextInt()));
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
