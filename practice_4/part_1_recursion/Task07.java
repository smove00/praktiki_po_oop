package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 7. Разложение на простые множители в неубывающем порядке. */
public class Task07 {
    private static void printFactors(long n) {
        if (n == 1) return;
        long factor = PrimeDivisors.smallestFactor(n);
        System.out.print(factor + " ");
        printFactors(n / factor);
    }

    public static void main(String[] args) {
        long n = new Scanner(System.in).nextLong();
        if (n > 1) printFactors(n);
        System.out.println();
    }
}
