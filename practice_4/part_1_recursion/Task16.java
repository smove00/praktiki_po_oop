package ru.mirea.oop.p4.recursion;

/** 16. Количество вхождений максимума; нет глобальных переменных. */
public class Task16 {
    private static final class Result {
        final int maximum;
        final int count;

        Result(int maximum, int count) {
            this.maximum = maximum;
            this.count = count;
        }
    }

    private static Result countMaximum() {
        int current = NumberReader.nextInt();
        if (current == 0) return new Result(Integer.MIN_VALUE, 0);
        Result tail = countMaximum();
        if (current > tail.maximum) return new Result(current, 1);
        if (current == tail.maximum) return new Result(current, tail.count + 1);
        return tail;
    }

    public static void main(String[] args) {
        System.out.println(countMaximum().count);
    }
}
