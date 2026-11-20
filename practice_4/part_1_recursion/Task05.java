package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 5. Сумма цифр без строк, массивов и циклов. */
public class Task05 {
    private static long sum(long n) {
        return n < 10 ? n : n % 10 + sum(n / 10);
    }

    public static void main(String[] args) {
        long n = new Scanner(System.in).nextLong();
        System.out.println(sum(n));
    }
}
