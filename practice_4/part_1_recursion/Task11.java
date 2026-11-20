package ru.mirea.oop.p4.recursion;

/** 11. Число единиц до первых двух идущих подряд нулей. */
public class Task11 {
    private static int countOnes() {
        int number = NumberReader.nextInt();
        if (number == 0) return afterZero();
        return (number == 1 ? 1 : 0) + countOnes();
    }

    private static int afterZero() {
        int number = NumberReader.nextInt();
        if (number == 0) return 0;
        return (number == 1 ? 1 : 0) + countOnes();
    }

    public static void main(String[] args) {
        System.out.println(countOnes());
    }
}
