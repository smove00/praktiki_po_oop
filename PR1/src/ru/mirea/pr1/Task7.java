package ru.mirea.pr1;

public class Task7 {
    public static long factorial(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException("Число должно находиться в диапазоне от 0 до 20");
        }

        long product = 1;
        for (int factor = 2; factor <= number; factor++) {
            product *= factor;
        }
        return product;
    }

    public static void main(String[] args) {
        int number = 5;
        System.out.println("Задание 7. Факториал " + number + " = " + factorial(number));
    }
}
