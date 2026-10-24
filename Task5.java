package ru.mirea.pr1;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("Задание 5. Аргументы командной строки:");

        if (args.length == 0) {
            System.out.println("Аргументы не переданы");
            return;
        }

        for (String argument : args) {
            System.out.println(argument);
        }
    }
}
