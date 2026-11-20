package ru.mirea.oop.p4.exceptions;

import java.util.Scanner;

/** Задание 2: ввод Qwerty, 0, 1.2, 1 и перехват разных исключений. */
public class Task02 {
    static class Exception2 {
        void exceptionDemo(Scanner scanner) {
            System.out.print("Enter an integer: ");
            String value = scanner.next();
            try {
                int divisor = Integer.parseInt(value);
                System.out.println("2 / " + divisor + " = " + 2 / divisor);
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer: " + value);
            } catch (ArithmeticException e) {
                System.out.println("Attempted division by zero");
            }
        }
    }

    public static void main(String[] args) {
        new Exception2().exceptionDemo(new Scanner(System.in));
    }
}
