package ru.mirea.oop.p2.part3.benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Main {
    private static final int SIZE = 30000;
    private static final int REPETITIONS = 1000;

    static void measure(String label, List<Integer> list) {
        for (int i = 0; i < SIZE; i++) list.add(i);
        long start = System.nanoTime();
        for (int i = 0; i < REPETITIONS; i++) list.add(SIZE + i);
        long append = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < REPETITIONS; i++) list.add(list.size() / 2, -i);
        long insert = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < REPETITIONS; i++) list.remove(list.size() / 2);
        long remove = System.nanoTime() - start;

        start = System.nanoTime();
        int found = 0;
        for (int i = 0; i < REPETITIONS; i++) {
            if (list.contains(SIZE / 2 + i)) found++;
        }
        long search = System.nanoTime() - start;

        System.out.printf(Locale.US, "%-11s %10.3f %10.3f %10.3f %10.3f (%d найдено)%n",
                label, append / 1e6, insert / 1e6, remove / 1e6, search / 1e6, found);
    }

    public static void main(String[] args) {
        System.out.println("Сравнение времени ArrayList / LinkedList, миллисекунды");
        System.out.printf("%-11s %10s %10s %10s %10s%n",
                "Тип", "Добавление", "Вставка", "Удаление", "Поиск");
        measure("ArrayList", new ArrayList<Integer>());
        measure("LinkedList", new LinkedList<Integer>());
        System.out.println("Результат зависит от JIT, нагрузки и аппаратного обеспечения.");
    }
}
