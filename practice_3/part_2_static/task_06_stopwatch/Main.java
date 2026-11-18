package ru.mirea.oop.p3.part2.stopwatch;

import java.util.Random;

public class Main {
    static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < numbers.length; j++) if (numbers[j] < numbers[min]) min = j;
            int temp = numbers[i]; numbers[i] = numbers[min]; numbers[min] = temp;
        }
    }
    public static void main(String[] args) {
        int[] numbers = new int[100_000];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) numbers[i] = random.nextInt();
        StopWatch watch = new StopWatch(); watch.start(); selectionSort(numbers); watch.stop();
        for (int i = 1; i < numbers.length; i++) if (numbers[i - 1] > numbers[i]) throw new AssertionError("Массив не отсортирован");
        System.out.println("Сортировка выбором " + numbers.length + " чисел: " + watch.getElapsedTime() + " мс");
    }
}
