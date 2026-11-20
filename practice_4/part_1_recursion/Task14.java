package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 14. Цифры числа слева направо. */
public class Task14 {
    private static void printDigits(long n) {
        if (n >= 10) printDigits(n / 10);
        System.out.print(n % 10 + " ");
    }

    public static void main(String[] args) {
        long n = new Scanner(System.in).nextLong();
        printDigits(n);
        System.out.println();
    }
}
