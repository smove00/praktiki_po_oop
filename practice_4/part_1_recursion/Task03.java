package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 3. Вывод всех чисел от A до B включительно. */
public class Task03 {
    private static void print(int a, int b) {
        System.out.print(a + " ");
        if (a != b) print(a + Integer.compare(b, a), b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        print(a, b);
        System.out.println();
    }
}
