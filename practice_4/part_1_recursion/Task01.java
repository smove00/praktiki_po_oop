package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 1. Треугольная последовательность: k повторяется k раз. */
public class Task01 {
    private static void print(int left, int number, int repeatsLeft) {
        if (left == 0) return;
        System.out.print(number + " ");
        if (repeatsLeft == 1) print(left - 1, number + 1, number + 1);
        else print(left - 1, number, repeatsLeft - 1);
    }

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if (n > 0) print(n, 1, 1);
        System.out.println();
    }
}
