package ru.mirea.oop.p4.recursion;

import java.util.Scanner;

/** 8. Проверка палиндрома без циклов. */
public class Task08 {
    private static boolean palindrome(String word, int left, int right) {
        if (left >= right) return true;
        return word.charAt(left) == word.charAt(right)
                && palindrome(word, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String word = new Scanner(System.in).next();
        System.out.println(palindrome(word, 0, word.length() - 1) ? "YES" : "NO");
    }
}
