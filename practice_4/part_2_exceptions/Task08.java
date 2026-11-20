package ru.mirea.oop.p4.exceptions;

import java.util.Scanner;

/** Задание 8: обработка в getKey(), повторная попытка после пустого ключа. */
public class Task08 {
    static class ThrowsDemo {
        void getKey(Scanner scanner) {
            while (true) {
                System.out.print("Enter a non-empty key: ");
                if (!scanner.hasNextLine()) {
                    System.out.println("Input ended");
                    return;
                }
                String key = scanner.nextLine();
                try {
                    printDetails(key);
                    return;
                } catch (Exception e) {
                    System.out.println("Invalid key: " + e.getMessage());
                    System.out.println("Please try again");
                }
            }
        }

        void printDetails(String key) throws Exception {
            System.out.println(getDetails(key));
        }

        private String getDetails(String key) throws Exception {
            if (key.isEmpty()) throw new Exception("Key set to empty string");
            return "data for " + key;
        }
    }

    public static void main(String[] args) {
        new ThrowsDemo().getKey(new Scanner(System.in));
    }
}
