package ru.mirea.oop.p4.recursion;

/** 17. Максимум последовательности до завершающего нуля. */
public class Task17 {
    private static int maximum() {
        int current = NumberReader.nextInt();
        if (current == 0) return 0;
        return Math.max(current, maximum());
    }

    public static void main(String[] args) {
        System.out.println(maximum());
    }
}
