package ru.mirea.oop.p4.exceptions;

import java.util.Scanner;

/** Задание 2. Ввод Qwerty, 0, 1.2, 1 и обработка ошибок. */
public class Task02 {
    public void exceptionDemo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        if (!scanner.hasNextLine()) {
            System.out.println("Invalid integer: no input");
            return;
        }
        String input = scanner.nextLine().trim();
        try {
            int number = Integer.parseInt(input);
            System.out.println("2 / " + number + " = " + (2 / number));
        } catch (NumberFormatException ex) {
            System.out.println("Invalid integer: " + input);
        } catch (ArithmeticException ex) {
            System.out.println("Attempted division by zero");
        }
    }

    public static void main(String[] args) {
        new Task02().exceptionDemo();
    }
}
