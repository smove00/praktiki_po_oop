package ru.mirea.pr1;

public class Demo {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        int total = 0;

        for (int value : values) {
            total += value;
        }

        System.out.println("Сумма: " + total);
        System.out.println(total > 10
                ? "Сумма > 10"
                : "Сумма <= 10");
    }
}
