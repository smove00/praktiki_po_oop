package ru.mirea.pr1;

public class Task3 {
    public static void main(String[] args) {
        // Массив задан при объявлении, как требуется в задании.
        int[] values = {3, 5, 7, 9, 11};
        int total = 0;

        for (int value : values) {
            total += value;
        }

        double mean = (double) total / values.length;
        System.out.println("Задание 3. Сумма: " + total);
        System.out.println("Среднее: " + mean);
    }
}
