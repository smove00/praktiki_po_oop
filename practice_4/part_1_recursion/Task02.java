package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 2. Вывод чисел от 1 до n. */
public class Task02 {
    private static void print(int n) {
        if (n < 1) return;
        print(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        print(n);
        System.out.println();
    }
}
