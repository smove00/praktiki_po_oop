package ru.mirea.oop.p4.exceptions;

import java.util.Scanner;

/** Задание 7: checked Exception и передача через throws по цепочке. */
public class Task07 {
    static class ThrowsDemo {
        void getKey(Scanner scanner) throws Exception {
            String key = scanner.nextLine();
            printDetails(key);
        }

        void printDetails(String key) throws Exception {
            // Не перехватываем исключение без необходимости: передаём вызывающему коду.
            String message = getDetails(key);
            System.out.println(message);
        }

        private String getDetails(String key) throws Exception {
            if (key.isEmpty()) {
                throw new Exception("Key set to empty string");
            }
            return "data for " + key;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter key (empty line causes checked Exception):");
        try {
            new ThrowsDemo().getKey(new Scanner(System.in));
        } catch (Exception e) {
            System.out.println("Handled in main: " + e.getMessage());
        }
    }
}
