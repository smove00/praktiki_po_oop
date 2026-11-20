package ru.mirea.oop.p4.exceptions;

import java.util.Scanner;

/** Задание 3: перехват общего Exception ПОСЛЕ конкретных catch. */
public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        try {
            int divisor = Integer.parseInt(scanner.next());
            System.out.println(2 / divisor);
        } catch (NumberFormatException e) {
            System.out.println("Not an integer: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Attempted division by zero");
        } catch (Exception e) {
            // Более общий тип должен идти после подклассов.
            System.out.println("Unexpected exception: " + e);
        }
    }
}
