package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 7. Простые множители в порядке неубывания с кратностями. */
public class Task07 {
    private static void factorize(long n, long divisor) {
        if (n == 1) return;
        if (divisor > n / divisor) {
            System.out.print(n + " ");
        } else if (n % divisor == 0) {
            System.out.print(divisor + " ");
            factorize(n / divisor, divisor);
        } else {
            factorize(n, divisor + 1);
        }
    }

    public static void main(String[] args) {
        long n = new Scanner(System.in).nextLong();
        if (n > 1) factorize(n, 2);
        System.out.println();
    }
}
