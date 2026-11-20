package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 15. Цифры числа справа налево. */
public class Task15 {
    private static void printDigits(long n) {
        System.out.print(n % 10 + " ");
        if (n >= 10) printDigits(n / 10);
    }

    public static void main(String[] args) {
        long n = new Scanner(System.in).nextLong();
        printDigits(n);
        System.out.println();
    }
}
