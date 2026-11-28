package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** Задание 3. Вывести от A до B включительно по возрастанию или убыванию. */
public class Task03 {
    private static void append(int value, int target, StringBuilder result) {
        if (result.length() > 0) result.append(' ');
        result.append(value);
        if (value == target) return; // базовый случай
        append(value + (value < target ? 1 : -1), target, result);
    }

    public static String range(int a, int b) {
        StringBuilder result = new StringBuilder();
        append(a, b, result);
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (!input.hasNextInt()) {
            System.err.println("Введите целое число A");
            return;
        }
        int a = input.nextInt();
        if (!input.hasNextInt()) {
            System.err.println("Введите целое число B");
            return;
        }
        System.out.println(range(a, input.nextInt()));
    }
}
