package ru.mirea.oop.p4.recursion;

/** 12. Вывод нечётных элементов до нуля; у рекурсивной функции нет параметров. */
public class Task12 {
    private static void printOdd() {
        int number = NumberReader.nextInt();
        if (number == 0) return;
        if (number % 2 != 0) System.out.println(number);
        printOdd();
    }

    public static void main(String[] args) {
        printOdd();
    }
}
