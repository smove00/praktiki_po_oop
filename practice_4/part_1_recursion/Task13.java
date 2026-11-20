package ru.mirea.oop.p4.recursion;

/** 13. Элементы на нечётных позициях (1, 3, 5 ...). */
public class Task13 {
    private static void printOddPositions() {
        int number = NumberReader.nextInt();
        if (number == 0) return;
        System.out.println(number);
        skipEvenPosition();
    }

    private static void skipEvenPosition() {
        int number = NumberReader.nextInt();
        if (number == 0) return;
        printOddPositions();
    }

    public static void main(String[] args) {
        printOddPositions();
    }
}
