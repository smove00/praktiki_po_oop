package ru.mirea.oop.p3.part2.stopwatch;

import java.util.Random;

public class Main {
    static class StopWatch {
        private long startTime;
        private long endTime;
        private boolean stopped;
        StopWatch() { start(); }
        public long getStartTime() { return startTime; }
        public long getEndTime() { return endTime; }
        public void start() {
            startTime = System.currentTimeMillis();
            endTime = startTime;
            stopped = false;
        }
        public void stop() {
            endTime = System.currentTimeMillis();
            stopped = true;
        }
        public long getElapsedTime() {
            return (stopped ? endTime : System.currentTimeMillis()) - startTime;
        }
    }

    // Сортировка выбором.
    static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) minIndex = j;
            }
            if (minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int count = args.length > 0 && "--quick".equals(args[0]) ? 1500 : 100_000;
        int[] values = new int[count];
        Random random = new Random(2026);
        for (int i = 0; i < values.length; i++) values[i] = random.nextInt();

        StopWatch watch = new StopWatch();
        watch.start();
        selectionSort(values);
        watch.stop();

        for (int i = 1; i < values.length; i++) {
            if (values[i - 1] > values[i]) throw new AssertionError("Ошибка сортировки");
        }
        System.out.println("Сортировка выбором " + count + " чисел");
        System.out.println("Время начала: " + watch.getStartTime());
        System.out.println("Время окончания: " + watch.getEndTime());
        System.out.println("Время выполнения: " + watch.getElapsedTime() + " мс");
    }
}
