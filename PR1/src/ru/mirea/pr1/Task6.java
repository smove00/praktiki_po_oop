package ru.mirea.pr1;

public class Task6 {
    public static void main(String[] args) {
        System.out.println("Задание 6. Первые 10 членов гармонического ряда:");

        for (int denominator = 1; denominator <= 10; denominator++) {
            double term = 1.0 / denominator;
            System.out.printf("1/%d = %.4f%n", denominator, term);
        }
    }
}
