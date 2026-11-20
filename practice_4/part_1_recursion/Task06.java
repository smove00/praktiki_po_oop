package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 6. Проверка числа на простоту с рекурсивным поиском делителей. */
public class Task06 {
    public static void main(String[] args) {
        long n = new Scanner(System.in).nextLong();
        System.out.println(n > 1 && PrimeDivisors.smallestFactor(n) == n ? "YES" : "NO");
    }
}
