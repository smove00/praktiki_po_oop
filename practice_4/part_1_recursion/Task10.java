package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 10. Разворот числа только рекурсией и целочисленной арифметикой. */
public class Task10 {
    private static long reverse(long n, long result) {
        if (n == 0) return result;
        return reverse(n / 10, result * 10 + n % 10);
    }

    public static void main(String[] args) {
        long n = new Scanner(System.in).nextLong();
        System.out.println(reverse(n, 0));
    }
}
