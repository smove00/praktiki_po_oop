package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 6. Проверка простоты рекурсивным подбором делителя. */
public class Task06 {
    private static boolean isPrime(long n, long divisor) {
        if (divisor > n / divisor) return true;
        if (n % divisor == 0) return false;
        return isPrime(n, divisor + 1);
    }

    public static void main(String[] args) {
        long n = new Scanner(System.in).nextLong();
        System.out.println(n > 1 && isPrime(n, 2) ? "YES" : "NO");
    }
}
