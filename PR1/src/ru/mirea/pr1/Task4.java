package ru.mirea.pr1;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Задание 4. Сколько чисел будет в массиве? ");
        int size = scanner.nextInt();

        while (size < 1) {
            System.out.print("Размер должен быть положительным. Повторите ввод: ");
            size = scanner.nextInt();
        }

        int[] values = new int[size];
        int index = 0;
        while (index < values.length) {
            System.out.print("Введите число " + (index + 1) + ": ");
            values[index] = scanner.nextInt();
            index++;
        }

        int total = 0;
        int smallest = values[0];
        int largest = values[0];
        index = 0;

        do {
            int current = values[index];
            total += current;

            if (current < smallest) {
                smallest = current;
            }
            if (current > largest) {
                largest = current;
            }
            index++;
        } while (index < values.length);

        System.out.println("Сумма: " + total);
        System.out.println("Минимум: " + smallest);
        System.out.println("Максимум: " + largest);
    }
}
