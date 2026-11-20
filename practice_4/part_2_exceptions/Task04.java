package ru.mirea.oop.p4.exceptions;

import java.util.Scanner;

/** Задание 4: finally выполняется и при успехе, и после перехваченной ошибки. */
public class Task04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        try {
            int divisor = Integer.parseInt(scanner.next());
            System.out.println(2 / divisor);
        } catch (NumberFormatException e) {
            System.out.println("Invalid integer");
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        } finally {
            System.out.println("Finally: input attempt finished");
        }
    }
}
